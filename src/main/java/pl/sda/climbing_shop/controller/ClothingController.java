package pl.sda.climbing_shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.climbing_shop.category.CategoryRepository;
import pl.sda.climbing_shop.customer.CustomerRepository;
import pl.sda.climbing_shop.product.Product;
import pl.sda.climbing_shop.product.ProductRepository;
import pl.sda.climbing_shop.review.Review;
import pl.sda.climbing_shop.review.ReviewRepository;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class ClothingController {

    private final ProductRepository productRepository;
    private final ReviewRepository reviewRepository;
    private final CustomerRepository customerRepository;
    private final CategoryRepository categoryRepository;

    @GetMapping("/{gender}")
    public String viewClothing(@PathVariable("gender") String gender) {
        return gender;
    }

    @GetMapping("/{gender}/{categoryName}")
    public String viewClothingCategory(@PathVariable("gender") String gender,
                                       @PathVariable("categoryName") String categoryName,
                                       @RequestParam(required = false) String subtype,
                                       @RequestParam(required = false) String size,
                                       @RequestParam(required = false) String color,
                                       @RequestParam(required = false) Integer brand,
                                       Model model, HttpSession session) {

        return View.viewClothing(gender, categoryName, subtype, size, color, brand, this.productRepository, this.categoryRepository, model, session);
    }

    @PostMapping("/{gender}/{categoryName}")
    public String filterClothingCategory(@PathVariable("gender") String gender,
                                         @PathVariable("categoryName") String categoryName,
                                         @ModelAttribute("product") Product product) {

        return "redirect:/" + gender + "/" + View.checkFilter(categoryName, product);
    }

    @PostMapping("/{gender}/{categoryName}/removeFilters")
    public String removeFilters(@PathVariable("gender") String gender,
                                @PathVariable("categoryName") String categoryName,
                                HttpSession session) {
        session.removeAttribute("products");
        return "redirect:/" + gender + "/" + categoryName;
    }

    @PostMapping("/{gender}/{categoryName}/addReview/{productId}")
    public String addReview(@PathVariable("gender") String gender,
                            @PathVariable("categoryName") String categoryName,
                            @PathVariable("productId") Integer productId,
                            Review review) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication.getName().equals("anonymousUser")) {
            return "redirect:/login";
        } else {
            return "redirect:/" + gender + "/" + View.addReviews(categoryName, productId, review,
                    this.customerRepository, productRepository, this.reviewRepository, authentication);
        }
    }
}
