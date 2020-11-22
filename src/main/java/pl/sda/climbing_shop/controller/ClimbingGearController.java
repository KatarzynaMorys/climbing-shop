package pl.sda.climbing_shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.climbing_shop.category.Category;
import pl.sda.climbing_shop.category.CategoryRepository;
import pl.sda.climbing_shop.product.Product;
import pl.sda.climbing_shop.product.ProductRepository;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/climbingGear")
public class ClimbingGearController {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @GetMapping
    public String viewClimbingGear() {
        return "climbingGear";
    }

    @GetMapping("/{categoryName}")
    public String viewClimbingGearCategory(@PathVariable("categoryName") String categoryName, Model model,
                                           @RequestParam(required = false) String type,
                                           @RequestParam(required = false) String size,
                                           @RequestParam(required = false) String color,
                                           @RequestParam(required = false) String brand) {

        return viewProducts(categoryName, model, type, size, color, brand, this.categoryRepository, this.productRepository);
    }

    @PostMapping("/{categoryName}")
    public String filterClimbingGearCategory(@PathVariable("categoryName") String categoryName,
                                             @ModelAttribute("product") Product product,
                                             Model model) {

        return "redirect:/climbingGear/" + filterProducts(categoryName, product, model);
    }

    static String filterProducts(@PathVariable("categoryName") String categoryName, @ModelAttribute("product") Product product, Model model) {
        model.addAttribute("type", product.getProductType());
        model.addAttribute("size", product.getProductSize());
        model.addAttribute("color", product.getProductColor());
        model.addAttribute("brand", product.getBrand().getBrandName());

        return categoryName + "?type=" + product.getProductType() +
                "&size=" + product.getProductSize() + "&color=" + product.getProductColor() +
                "&brand=" + product.getBrand().getBrandName();
    }

    static String viewProducts(@PathVariable("categoryName") String categoryName, Model model,
                               @RequestParam(required = false) String type,
                               @RequestParam(required = false) String size,
                               @RequestParam(required = false) String color,
                               @RequestParam(required = false) String brand,
                               CategoryRepository categoryRepository,
                               ProductRepository productRepository) {

        Category category = categoryRepository.findCategoryByCategoryName(categoryName).get();
        model.addAttribute("category", category);

        List<Product> products;

        if (type == null || color == null || size == null) {
            products = productRepository.findProductsByCategory_CategoryName(categoryName);
        } else {
            products = productRepository.findProductsByCategory_CategoryNameAndBrand_BrandNameAndProductTypeAndProductSizeAndProductColor
                    (categoryName, brand, type, size, color);
        }
        model.addAttribute("products", products);

        List<String> types = productRepository.findDistinctTypes(categoryName);
        model.addAttribute("types", types);

        List<String> brands = productRepository.findDistinctBrands(categoryName);
        model.addAttribute("brands", brands);

        List<String> sizes = productRepository.findDistinctSizes(categoryName);
        model.addAttribute("sizes", sizes);

        List<String> colors = productRepository.findDistinctColors(categoryName);
        model.addAttribute("colors", colors);

        model.addAttribute("product", new Product());

        return categoryName;
    }

}