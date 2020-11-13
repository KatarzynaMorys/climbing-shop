package pl.sda.climbing_shop.order;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import pl.sda.climbing_shop.customer.Customer;
import pl.sda.climbing_shop.entity.Product;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String orderId;

    private String orderStatus;

    @CreationTimestamp
    private LocalDate orderDate;

    @UpdateTimestamp
    private LocalDate deliveryDate;

    @ManyToOne
    private Customer customer;

    @ManyToMany(mappedBy = "orders")
    private List<Product> products;

}
