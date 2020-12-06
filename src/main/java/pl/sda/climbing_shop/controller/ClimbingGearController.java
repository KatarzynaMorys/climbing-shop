package pl.sda.climbing_shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.climbing_shop.category.Category;
import pl.sda.climbing_shop.category.CategoryRepository;
import pl.sda.climbing_shop.customer.Customer;
import pl.sda.climbing_shop.customer.CustomerRepository;
import pl.sda.climbing_shop.product.Product;
import pl.sda.climbing_shop.product.ProductRepository;
import pl.sda.climbing_shop.review.Review;
import pl.sda.climbing_shop.review.ReviewRepository;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/climbingGear")
public class ClimbingGearController {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ReviewRepository reviewRepository;
    private final CustomerRepository customerRepository;

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
                                             @ModelAttribute("product") Product product) {

        return "redirect:/climbingGear/" + filterProducts(categoryName, product);
    }

    @PostMapping("/{categoryName}/addReview/{productId}")
    public String addReviews(@PathVariable("categoryName") String categoryName,
                             @PathVariable("productId") Integer productId,
                             Review review) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication.getName().equals("anonymousUser")) {
            return "redirect:/login";
        } else {
            return "redirect:/climbingGear/" + addReviews(categoryName, productId, review,
                    this.customerRepository, productRepository, this.reviewRepository, authentication);
        }
    }

    static String addReviews(@PathVariable("categoryName") String categoryName, @PathVariable("productId") Integer productId, Review review,
                             CustomerRepository customerRepository, ProductRepository productRepository, ReviewRepository reviewRepository,
                             Authentication authentication) {

        Customer customer = customerRepository
                .findByEmail(authentication.getName())
                .orElseThrow();

        Review newReview = Review.builder()
                .content(review.getContent())
                .rating(review.getRating())
                .product(productRepository.findById(productId).get())
                .createdAt(LocalDate.now())
                .customer(customer)
                .build();

        reviewRepository.save(newReview);

        return categoryName;
    }

    static String filterProducts(@PathVariable("categoryName") String categoryName, @ModelAttribute("product") Product product) {

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