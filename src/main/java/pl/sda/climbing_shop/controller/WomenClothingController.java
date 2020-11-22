package pl.sda.climbing_shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.climbing_shop.category.CategoryRepository;
import pl.sda.climbing_shop.product.Product;
import pl.sda.climbing_shop.product.ProductRepository;

import static pl.sda.climbing_shop.controller.ClimbingGearController.filterProducts;
import static pl.sda.climbing_shop.controller.ClimbingGearController.viewProducts;

@Controller
@RequiredArgsConstructor
@RequestMapping("/womenClothing")
public class WomenClothingController {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @GetMapping
    public String viewWomenClothing() {
        return "womenClothing";
    }

    @GetMapping("/{categoryName}")
    public String viewWomenClothingCategory(@PathVariable("categoryName") String categoryName, Model model,
                                            @RequestParam(required = false) String type,
                                            @RequestParam(required = false) String size,
                                            @RequestParam(required = false) String color,
                                            @RequestParam(required = false) String brand) {

        return viewProducts(categoryName, model, type, size, color, brand, this.categoryRepository, this.productRepository);
    }

    @PostMapping("/{categoryName}")
    public String filterWomenClothingCategory(@PathVariable("categoryName") String categoryName,
                                         @ModelAttribute("product") Product product,
                                         Model model) {

        return "redirect:/womenClothing/" + filterProducts(categoryName, product, model);
    }

}
