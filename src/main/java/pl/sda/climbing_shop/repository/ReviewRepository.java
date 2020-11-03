package pl.sda.climbing_shop.repository;

import org.springframework.data.repository.CrudRepository;
import pl.sda.climbing_shop.entity.Review;

public interface ReviewRepository extends CrudRepository<Review,Integer> {
}
