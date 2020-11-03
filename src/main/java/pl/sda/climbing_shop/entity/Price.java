package pl.sda.climbing_shop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "prices")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Price {

    @Id
    @GeneratedValue
    private Integer priceId;
    private Double basePrice;
    private Integer discount;
    @OneToOne(mappedBy = "price")
    private Product product;
}
