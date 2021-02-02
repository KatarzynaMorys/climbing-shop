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
@RequestMapping("/climbingGear")
public class ClimbingGearController {

    private final ProductRepository productRepository;
    private final ReviewRepository reviewRepository;
    private final CustomerRepository customerRepository;
    private final CategoryRepository categoryRepository;

    @GetMapping
    public String viewClimbingGear() {
        return "climbingGear";
    }

    @GetMapping("/{categoryName}")
    public String viewClimbingGearCategory(@PathVariable("categoryName") String categoryName,
                                           @RequestParam(required = false) String type,
                                           @RequestParam(required = false) String size,
                                           @RequestParam(required = false) String color,
                                           @RequestParam(required = false) Integer brand,
                                           Model model, HttpSession session) {

        return View.viewClimbingGear(categoryName, type, size, color, brand, this.productRepository, this.categoryRepository, model, session);
    }

    @PostMapping("/{categoryName}")
    public String filterClimbingGearCategory(@PathVariable("categoryName") String categoryName,
                                             @ModelAttribute("product") Product product) {

        return "redirect:/climbingGear/" + View.checkFilter(categoryName, product);
    }

    @PostMapping("/{categoryName}/removeFilters")
    public String removeFilters(@PathVariable("categoryName") String categoryName,
                                HttpSession session) {
        session.removeAttribute("products");
        return "redirect:/climbingGear/" + categoryName;
    }

    @PostMapping("/{categoryName}/addReview/{productId}")
    public String addReview(@PathVariable("categoryName") String categoryName,
                            @PathVariable("productId") Integer productId,
                            Review review) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication.getName().equals("anonymousUser")) {
            return "redirect:/login";
        } else {
            return "redirect:/climbingGear/" + View.addReviews(categoryName, productId, review,
                    this.customerRepository, productRepository, this.reviewRepository, authentication);
        }
    }
}