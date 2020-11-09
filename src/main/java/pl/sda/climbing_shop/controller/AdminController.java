package pl.sda.climbing_shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.climbing_shop.entity.Brand;
import pl.sda.climbing_shop.entity.Category;
import pl.sda.climbing_shop.entity.Price;
import pl.sda.climbing_shop.entity.Product;
import pl.sda.climbing_shop.formData.ProductFormData;
import pl.sda.climbing_shop.repository.BrandRepository;
import pl.sda.climbing_shop.repository.CategoryRepository;
import pl.sda.climbing_shop.repository.PriceRepository;
import pl.sda.climbing_shop.repository.ProductRepository;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;
    private final PriceRepository priceRepository;

    @GetMapping("/newProduct")
    public String returnAdminHome() {
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
                .productColor(formData.getProductColor())
                .productSize(formData.getProductSize())
                .quantity(formData.getQuantity())
                .price(price)
                .build();

        this.priceRepository.save(price);
        this.categoryRepository.save(category);
        this.brandRepository.save(brand);

        newProduct.setBrand(brand);
        newProduct.setCategory(category);
        newProduct.setPrice(price);

        this.productRepository.save(newProduct);

        return "redirect:productList";
    }

    @GetMapping("/productList")
    public String returnProductList(Model model) {
        Iterable<Product> products = this.productRepository.findAll();
        model.addAttribute("products", products);
        return "productList";
    }
}
