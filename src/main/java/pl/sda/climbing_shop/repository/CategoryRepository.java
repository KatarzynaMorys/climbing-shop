package pl.sda.climbing_shop.repository;

import org.springframework.data.repository.CrudRepository;
import pl.sda.climbing_shop.entity.Category;

public interface CategoryRepository extends CrudRepository<Category,Integer> {
}
