package pl.sda.climbing_shop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "prices")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Price {

    @Id
    @GeneratedValue
    private Integer priceId;
    private Double basePrice;
    private Integer discountValue;
    @OneToOne(mappedBy = "price")
    private Product product;
}
