package pl.sda.climbing_shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.sda.climbing_shop.category.Category;
import pl.sda.climbing_shop.category.CategoryRepository;
import pl.sda.climbing_shop.product.Product;
import pl.sda.climbing_shop.product.ProductRepository;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ClimbingGearController {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @GetMapping("/climbingGear")
    public String viewClimbingGear() {
        return "climbingGear";
    }

    @GetMapping("/climbingGear/{id}")
    public String viewClimbingShoes(@PathVariable("id") int id, Model model) {
        Category category = this.categoryRepository.findById(id).get();
        model.addAttribute("category", category);
        System.out.println(category.getCategoryName());
        List<Product> products = this.productRepository.findProductsByCategory_CategoryId(id);
        model.addAttribute("products", products);
        return "climbingShoes";
    }

    @GetMapping("/climbingGear/harnesses")
    public String viewHarnesses() {
        return "harnesses";
    }

    @GetMapping("/climbingGear/belay_rappel")
    public String viewBelayRappel() {
        return "belayRappel";
    }

    @GetMapping("/climbingGear/carabiners")
    public String viewCarabiners() {
        return "carabiners";
    }

    @GetMapping("/climbingGear/quickdraws")
    public String viewQuickdraws() {
        return "quickdraws";
    }

    @GetMapping("/climbingGear/ropes")
    public String viewRopes() {
        return "ropes";
    }

    @GetMapping("/climbingGear/helmets")
    public String viewHelmets() {
        return "helmets";
    }

}