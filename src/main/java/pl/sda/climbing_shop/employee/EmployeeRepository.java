package pl.sda.climbing_shop.employee;

import org.springframework.data.repository.CrudRepository;
import pl.sda.climbing_shop.customer.Customer;

import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {


    Optional<Employee> findByEmail(String username);
}
