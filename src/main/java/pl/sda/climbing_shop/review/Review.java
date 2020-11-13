package pl.sda.climbing_shop.review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.climbing_shop.product.Product;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reviews")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue
    private Integer reviewId;
    private Integer rating;
    private String content;
    private LocalDate createdAt;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
