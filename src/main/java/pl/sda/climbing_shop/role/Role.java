package pl.sda.climbing_shop.role;

import lombok.Data;
import pl.sda.climbing_shop.customer.Customer;
import pl.sda.climbing_shop.employee.Employee;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;

    private String name;

    @OneToMany(mappedBy = "role")
    private List<Employee> employees;

    @OneToMany(mappedBy = "role")
    private List<Customer> customers;

}
