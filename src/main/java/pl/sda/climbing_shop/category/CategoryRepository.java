package pl.sda.climbing_shop.category;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category,Integer> {

    Optional<Category> findCategoryByCategoryName(String categoryName);
}
