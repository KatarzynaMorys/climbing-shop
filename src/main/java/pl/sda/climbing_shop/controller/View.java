package pl.sda.climbing_shop.controller;

import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.climbing_shop.customer.Customer;
import pl.sda.climbing_shop.customer.CustomerRepository;
import pl.sda.climbing_shop.product.Product;
import pl.sda.climbing_shop.product.ProductRepository;
import pl.sda.climbing_shop.review.Review;
import pl.sda.climbing_shop.review.ReviewRepository;

import java.time.LocalDate;
import java.util.List;

public class View {

    static String viewClimbingGear(@PathVariable("categoryName") String categoryName,
                                   @RequestParam(required = false) String type,
                                   @RequestParam(required = false) String size,
                                   @RequestParam(required = false) String color,
                                   @RequestParam(required = false) String brand,
                                   Model model, ProductRepository productRepository) {

        List<Product> products;

        if (type == null || color == null || size == null || brand == null) {
            products = productRepository.findProductsByCategory_CategoryName(categoryName);
        } else {
            products = productRepository.findProductsByCategory_CategoryNameAndBrand_BrandNameAndProductTypeAndProductSizeAndProductColor
                    (categoryName, brand, type, size, color);
        }

        return getClimbingGearModel(categoryName, model, productRepository, products);
    }

    static String viewClothing(@PathVariable("gender") String gender,
                               @PathVariable("categoryName") String categoryName,
                               @RequestParam(required = false) String subtype,
                               @RequestParam(required = false) String size,
                               @RequestParam(required = false) String color,
                               @RequestParam(required = false) String brand,
                               Model model, ProductRepository productRepository) {

        List<Product> products;

        if (subtype == null || color == null || size == null || brand == null) {
            products = productRepository.findProductsByCategory_CategoryNameAndProductType(categoryName, gender);
        } else {
            products = productRepository.findProductsByCategory_CategoryNameAndBrand_BrandNameAndProductSubtypeAndProductSizeAndProductColor(
                    categoryName, brand, subtype, size, color);
        }

        return getClothingModel(gender, categoryName, model, productRepository, products);
    }

    private static String getClimbingGearModel(@PathVariable("categoryName") String categoryName, Model model, ProductRepository productRepository, List<Product> products) {
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

    private static String getClothingModel(@PathVariable("gender") String gender,
                                           @PathVariable("categoryName") String categoryName,
                                           Model model, ProductRepository productRepository, List<Product> products) {

        model.addAttribute("products", products);

        List<String> subtypes = productRepository.findDistinctClothingSubtypes(categoryName, gender);
        model.addAttribute("subtypes", subtypes);

        List<String> brands = productRepository.findDistinctClothingBrands(categoryName, gender);
        model.addAttribute("brands", brands);

        List<String> sizes = productRepository.findDistinctClothingSizes(categoryName, gender);
        model.addAttribute("sizes", sizes);

        List<String> colors = productRepository.findDistinctClothingColors(categoryName, gender);
        model.addAttribute("colors", colors);

        model.addAttribute("product", new Product());

        return categoryName;
    }

    static String filterClimbingGear(@PathVariable("categoryName") String categoryName, @ModelAttribute("product") Product product) {

        return categoryName + "?type=" + product.getProductType() +
                "&size=" + product.getProductSize() + "&color=" + product.getProductColor() +
                "&brand=" + product.getBrand().getBrandName();
    }

    static String filterClothing(@PathVariable("categoryName") String categoryName, @ModelAttribute("product") Product product) {

        return categoryName + "?subtype=" + product.getProductSubtype() +
                "&size=" + product.getProductSize() + "&color=" + product.getProductColor() +
                "&brand=" + product.getBrand().getBrandName();
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
}
