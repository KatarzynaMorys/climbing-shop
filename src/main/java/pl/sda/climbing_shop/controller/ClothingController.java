package pl.sda.climbing_shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.climbing_shop.customer.CustomerRepository;
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

    @GetMapping("/{gender}")
    public String viewClothing(@PathVariable("gender") String gender) {
        return gender;
    }

    @GetMapping("/{gender}/{categoryName}")
    public String viewClothingCategory(@PathVariable("gender") String gender,
                                       @PathVariable("categoryName") String categoryName,
                                       @RequestParam(required = false) String productSubtype,
                                       @RequestParam(required = false) String productSize,
                                       @RequestParam(required = false) String productColor,
                                       @RequestParam(required = false) String brand,
                                       Model model, HttpSession session) {

        return View.viewClothing(gender, categoryName, productSubtype, productSize, productColor, brand, model, this.productRepository, session);
    }

    @PostMapping("/{gender}/{categoryName}")
    public String removeFilters(@PathVariable("gender") String gender,
                                @PathVariable("categoryName") String categoryName,
                                HttpSession session) {

        session.removeAttribute("filterMap");
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
