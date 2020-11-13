package pl.sda.climbing_shop.brand;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.climbing_shop.product.Product;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "brands")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Brand {

    @Id
    @GeneratedValue
    private Integer brandId;
    private String brandName;
    @OneToMany(mappedBy = "brand")
    private List<Product> products;
}
