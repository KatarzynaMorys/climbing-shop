package pl.sda.climbing_shop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue
    private Integer categoryId;
    private String categoryName;
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
