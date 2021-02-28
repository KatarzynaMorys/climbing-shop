package pl.sda.climbing_shop.controller;

import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.climbing_shop.brand.Brand;
import pl.sda.climbing_shop.customer.Customer;
import pl.sda.climbing_shop.customer.CustomerRepository;
import pl.sda.climbing_shop.product.Product;
import pl.sda.climbing_shop.product.ProductRepository;
import pl.sda.climbing_shop.review.Review;
import pl.sda.climbing_shop.review.ReviewRepository;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class View {

    static String viewClimbingGear (String categoryName, String type, String size, String color, String brand,
                                   Model model, ProductRepository productRepository, HttpSession session) {

        List<Product> products = productRepository.findProductsByCategory_CategoryName(categoryName);

        final String filterAttributeName = "filterMap";

        Map<String, String> oldFilter = (Map) session.getAttribute(filterAttributeName);

        Map<String, String> newFilter = new HashMap<>() {{
            put("productColor", color);
            put("productType", type);
            put("productSize", size);
            put("brand", brand);
        }};

        products = getProducts(session, products, filterAttributeName, oldFilter, newFilter);

        return getClimbingGearModel(categoryName, model, productRepository, products);
    }


    static String viewClothing(String gender, String categoryName, String subtype, String size, String color, String brand,
                               Model model, ProductRepository productRepository, HttpSession session) {

        List<Product> products = productRepository.findProductsByCategory_CategoryNameAndProductType(categoryName, gender);

        final String filterAttributeName = "filterMap";

        Map<String, String> oldFilter = (Map) session.getAttribute(filterAttributeName);

        Map<String, String> newFilter = new HashMap<>() {{
            put("productColor", color);
            put("productSubtype", subtype);
            put("productSize", size);
            put("brand", brand);
        }};

        products = getProducts(session, products, filterAttributeName, oldFilter, newFilter);

        return getClothingModel(gender, categoryName, model, productRepository, products);
    }

    private static List<Product> getProducts(HttpSession session, List<Product> products, String filterAttributeName, Map<String, String> oldFilter, Map<String, String> newFilter) {
        for (Map.Entry<String, String> kv : newFilter.entrySet()) {
            String value = kv.getValue();
            String attribute = kv.getKey();

            if (value == null && oldFilter != null && oldFilter.get(attribute) != null) {
                value = oldFilter.get(attribute);
                newFilter.replace(attribute, value);
            }

            if (value != null) {
                products = products.stream()
                        .filter(product -> product.getValue(attribute).equals(kv.getValue()))
                        .collect(Collectors.toList());
            }
        }
        session.setAttribute(filterAttributeName, newFilter);

        return products;
    }

    private static String getClimbingGearModel(String categoryName, Model model, ProductRepository productRepository, List<Product> products) {

        model.addAttribute("products", products);

        List<String> types = productRepository.findDistinctTypes(categoryName);
        model.addAttribute("types", types);

        List<Brand> brands = productRepository.findDistinctBrands(categoryName);
        model.addAttribute("brands", brands);

        List<String> sizes = productRepository.findDistinctSizes(categoryName);
        model.addAttribute("sizes", sizes);

        List<String> colors = productRepository.findDistinctColors(categoryName);
        model.addAttribute("colors", colors);

        model.addAttribute("product", new Product());

        return categoryName;
    }

    private static String getClothingModel(String gender, String categoryName, Model model, ProductRepository productRepository, List<Product> products) {

        model.addAttribute("products", products);

        List<String> subtypes = productRepository.findDistinctClothingSubtypes(categoryName, gender);
        model.addAttribute("subtypes", subtypes);

        List<Brand> brands = productRepository.findDistinctClothingBrands(categoryName, gender);
        model.addAttribute("brands", brands);

        List<String> sizes = productRepository.findDistinctClothingSizes(categoryName, gender);
        model.addAttribute("sizes", sizes);

        List<String> colors = productRepository.findDistinctClothingColors(categoryName, gender);
        model.addAttribute("colors", colors);

        model.addAttribute("product", new Product());

        return categoryName;
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
