package pl.sda.climbing_shop.product;

import lombok.Data;

@Data
public class ProductFormData {
    private String categoryName;
    private String brandName;
    private String productName;
    private String productType;
    private String productColor;
    private Double basePrice;
    private Integer discountValue;
    private String productSize;
    private Integer quantity;
    private String productDescription;
    private String image;
}
