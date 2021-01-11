package pl.sda.climbing_shop.controller;

import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.climbing_shop.brand.Brand;
import pl.sda.climbing_shop.brand.BrandRepository;
import pl.sda.climbing_shop.customer.Customer;
import pl.sda.climbing_shop.customer.CustomerRepository;
import pl.sda.climbing_shop.product.Product;
import pl.sda.climbing_shop.product.ProductRepository;
import pl.sda.climbing_shop.review.Review;
import pl.sda.climbing_shop.review.ReviewRepository;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
                               Model model, ProductRepository productRepository, HttpSession session) {

        List<Product> products = productRepository.findProductsByCategory_CategoryNameAndProductType(categoryName, gender);
        if (session.getAttribute("products") == null) {
            session.setAttribute("products", products);
        } else {
            List<Product> filteredProductsList = (List<Product>) session.getAttribute("products");

            if (subtype != null) {
                List<Product> filteredBySubtype = filteredProductsList.stream()
                        .filter(p -> p.getProductSubtype().equalsIgnoreCase(subtype))
                        .collect(Collectors.toList());
                session.setAttribute("products", filteredBySubtype);
            }

            if (size != null) {
                List<Product> filteredBySize = filteredProductsList.stream()
                        .filter(p -> p.getProductSize().equalsIgnoreCase(size))
                        .collect(Collectors.toList());
                session.setAttribute("products", filteredBySize);
            }

            if (color != null) {
                List<Product> filteredByColor = filteredProductsList.stream()
                        .filter(p -> p.getProductColor().equalsIgnoreCase(color))
                        .collect(Collectors.toList());
                session.setAttribute("products", filteredByColor);
            }

            if (brand != null) {
                List<Product> filteredByBrand = filteredProductsList.stream()
                        .filter(p -> p.getBrand().getBrandName().equalsIgnoreCase(brand))
                        .collect(Collectors.toList());
                session.setAttribute("products", filteredByBrand);
            }
        }

        return getClothingModel(gender, categoryName, model, productRepository);
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
                                           Model model, ProductRepository productRepository) {

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

        if (product.getProductSubtype() != null) {
            return categoryName + "?subtype=" + product.getProductSubtype();
        }

        if (product.getProductSize() != null) {
            return categoryName + "?size=" + product.getProductSize();
        }

        if (product.getProductColor() != null) {
            return categoryName + "?color=" + product.getProductColor();
        }

        if (product.getBrand().getBrandName() != null) {
            return categoryName + "?brand=" + product.getBrand().getBrandName();
        }
        else return categoryName;
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
