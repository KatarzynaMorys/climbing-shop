package pl.sda.climbing_shop.customer;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    Optional<Customer> findByEmail(String email);
}
