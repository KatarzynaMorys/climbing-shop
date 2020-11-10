package pl.sda.climbing_shop.address;

import lombok.Data;
import pl.sda.climbing_shop.customer.Customer;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String state;

    private String city;

    private String street;

    private String streetNumber;

    private String postalCode;

    @OneToMany(mappedBy = "address")
    private List<Customer> customer;


}
