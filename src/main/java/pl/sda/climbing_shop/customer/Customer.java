package pl.sda.climbing_shop.customer;

import lombok.Data;
import pl.sda.climbing_shop.address.Address;
import pl.sda.climbing_shop.order.Order;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String lastName;

    private String phone;

    private String email;

    @ManyToOne
    private Address address;

    private String hashPassword;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;


}
