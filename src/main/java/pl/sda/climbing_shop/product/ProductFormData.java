package pl.sda.climbing_shop.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ProductFormData {
    private Integer productId;
    private String categoryName;
    private String brandName;
    private String productName;
    private String productType;
    private String productSubtype;
    private String productColor;
    private Double basePrice;
    private Integer discountValue;
    private String productSize;
    private Integer quantity;
    private String productDescription;
    private String image;
    private Integer quantityInStore;
    private String message;
}
