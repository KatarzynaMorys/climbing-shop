package pl.sda.climbing_shop.address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.climbing_shop.customer.Customer;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "addresses")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;

    private String state;

    private String city;

    private String street;

    private String streetNumber;

    private String postalCode;

    @OneToMany(mappedBy = "address")
    private List<Customer> customer;


}
