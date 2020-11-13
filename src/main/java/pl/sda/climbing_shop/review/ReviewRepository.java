package pl.sda.climbing_shop.review;

import org.springframework.data.repository.CrudRepository;
import pl.sda.climbing_shop.review.Review;

public interface ReviewRepository extends CrudRepository<Review,Integer> {
}
