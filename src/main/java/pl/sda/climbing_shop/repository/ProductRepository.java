package pl.sda.climbing_shop.repository;

import org.springframework.data.repository.CrudRepository;
import pl.sda.climbing_shop.entity.Product;

public interface ProductRepository extends CrudRepository<Product,Integer> {
}
