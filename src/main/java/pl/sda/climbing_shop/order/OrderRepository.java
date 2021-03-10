package pl.sda.climbing_shop.order;

import org.springframework.data.repository.CrudRepository;
import pl.sda.climbing_shop.customer.Customer;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Integer> {

    List<Order> findOrdersByCustomerIs(Customer customer);
}
