package pl.sda.climbing_shop.category;

import org.springframework.data.repository.CrudRepository;
import pl.sda.climbing_shop.category.Category;

public interface CategoryRepository extends CrudRepository<Category,Integer> {
}
