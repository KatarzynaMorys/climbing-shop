package pl.sda.climbing_shop.customer;

import lombok.Data;
import pl.sda.climbing_shop.address.Address;
import pl.sda.climbing_shop.role.Role;
import pl.sda.climbing_shop.order.Order;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    private String firstName;

    private String lastName;

    private String phone;

    private String email;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    private String hashPassword;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

}
