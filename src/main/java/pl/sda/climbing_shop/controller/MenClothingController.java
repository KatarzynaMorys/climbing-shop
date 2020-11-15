package pl.sda.climbing_shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.climbing_shop.category.Category;
import pl.sda.climbing_shop.category.CategoryRepository;
import pl.sda.climbing_shop.product.Product;
import pl.sda.climbing_shop.product.ProductRepository;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/menClothing")
public class MenClothingController {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @GetMapping
    public String viewMenClothing() {
        return "menClothing";
    }

    @GetMapping("/{categoryName}")
    public String viewMenClothingCategory(@PathVariable("categoryName") String name, Model model) {
        Category category = this.categoryRepository.findCategoryByCategoryName(name).get();
        model.addAttribute("category", category);
        List<Product> products = this.productRepository.findProductsByCategory_CategoryName(name);
        model.addAttribute("products", products);
        return name;
    }

}
