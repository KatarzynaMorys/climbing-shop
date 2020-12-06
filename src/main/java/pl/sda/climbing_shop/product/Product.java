package pl.sda.climbing_shop.product;

import lombok.*;
import pl.sda.climbing_shop.brand.Brand;
import pl.sda.climbing_shop.category.Category;
import pl.sda.climbing_shop.review.Review;
import pl.sda.climbing_shop.order.Order;
import pl.sda.climbing_shop.price.Price;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue
    private Integer productId;
    private String productName;
    private String productType;
    private String productSubtype;
    private String productColor;
    private String productSize;
    private Integer quantity;
    private String productDescription;
    private String image;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
    @OneToOne
    @JoinColumn(name = "price_id")
    private Price price;
    @OneToMany(mappedBy = "product")
    private List<Review> reviews;
    @ManyToMany
    private List<Order> orders;
}
