package pl.sda.climbing_shop.product;

import org.springframework.data.repository.CrudRepository;
import pl.sda.climbing_shop.product.Product;

public interface ProductRepository extends CrudRepository<Product,Integer> {
}
