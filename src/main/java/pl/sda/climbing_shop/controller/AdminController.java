package pl.sda.climbing_shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.climbing_shop.brand.Brand;
import pl.sda.climbing_shop.category.Category;
import pl.sda.climbing_shop.price.Price;
import pl.sda.climbing_shop.product.Product;
import pl.sda.climbing_shop.product.ProductFormData;
import pl.sda.climbing_shop.brand.BrandRepository;
import pl.sda.climbing_shop.category.CategoryRepository;
import pl.sda.climbing_shop.price.PriceRepository;
import pl.sda.climbing_shop.product.ProductRepository;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;
    private final PriceRepository priceRepository;

    @GetMapping("/newProduct")
    public String returnAdminHome(Model model) {
        model.addAttribute("categories", this.categoryRepository.findAll());
        model.addAttribute("brands", this.brandRepository.findAll());
        return "adminHome";
    }

    @PostMapping("/newProduct")
    public String addNewProduct(ProductFormData formData) {

        Price price = Price.builder()
                .basePrice(formData.getBasePrice())
                .discountValue(formData.getDiscountValue())
                .build();

        Category category = Category.builder()
                .categoryName(formData.getCategoryName())
                .build();

        Brand brand = Brand.builder()
                .brandName(formData.getBrandName())
                .build();

        Product newProduct = Product.builder()
                .category(category)
                .brand(brand)
                .productName(formData.getProductName())
                .productType(formData.getProductType())
                .productSubtype(formData.getProductSubtype())
                .productColor(formData.getProductColor())
                .productSize(formData.getProductSize())
                .productDescription(formData.getProductDescription())
                .image(formData.getImage())
                .quantity(formData.getQuantity())
                .price(price)
                .build();

        if (hasNewCategory(category, newProduct)) {
            this.categoryRepository.save(category);
            newProduct.setCategory(category);
        }

        if (hasNewBrand(brand, newProduct)) {
            this.brandRepository.save(brand);
            newProduct.setBrand(brand);
        }

        this.priceRepository.save(price);

        newProduct.setPrice(price);

        this.productRepository.save(newProduct);

        return "redirect:productList";
    }

    private boolean hasNewCategory(Category category, Product product) {
        boolean performSave = true;
        for (Category tempC : this.categoryRepository.findAll()) {
            if (tempC.getCategoryName().equals(category.getCategoryName())) {
                performSave = false;
                product.setCategory(tempC);
                break;
            }
        }
        return performSave;
    }

    private boolean hasNewBrand(Brand brand, Product product) {
        boolean performSave = true;
        for (Brand tempB : this.brandRepository.findAll()) {
            if (tempB.getBrandName().equals(brand.getBrandName())) {
                performSave = false;
                product.setBrand(tempB);
                break;
            }
        }
        return performSave;
    }

    @GetMapping("/productList")
    public String returnProductList(Model model) {
        model.addAttribute("products", this.productRepository.findAll());
        return "productList";
    }
}
