package pl.sda.climbing_shop.order;

import lombok.Data;
import pl.sda.climbing_shop.customer.Customer;
import pl.sda.climbing_shop.product.Product;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    private String orderStatus;

    private LocalDate orderDate;

    private LocalDate deliveryDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany(mappedBy = "orders")
    private List<Product> products;

}
