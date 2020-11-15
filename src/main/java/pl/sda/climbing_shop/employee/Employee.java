package pl.sda.climbing_shop.employee;

import lombok.Data;
import pl.sda.climbing_shop.role.Role;

import javax.persistence.*;

@Data
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;

    private String firstName;

    private String lastName;

    private String email;

    private String hashPassword;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

}
