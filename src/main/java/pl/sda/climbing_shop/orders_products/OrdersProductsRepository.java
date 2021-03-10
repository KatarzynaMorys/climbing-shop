package pl.sda.climbing_shop.orders_products;

import org.springframework.data.repository.CrudRepository;
import pl.sda.climbing_shop.order.Order;


import java.util.List;

public interface OrdersProductsRepository extends CrudRepository<OrdersProducts, Integer> {

    List<OrdersProducts> findByOrderIs(Order order);
}
