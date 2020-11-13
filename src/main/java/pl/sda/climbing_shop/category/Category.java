package pl.sda.climbing_shop.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.climbing_shop.product.Product;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

    @Id
    @GeneratedValue
    private Integer categoryId;
    private String categoryName;
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
