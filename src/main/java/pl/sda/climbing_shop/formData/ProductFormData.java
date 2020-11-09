package pl.sda.climbing_shop.formData;

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
}
