package pl.sda.climbing_shop.product;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Integer> {

    List<Product> findProductsByCategory_CategoryName(String categoryName);
}
