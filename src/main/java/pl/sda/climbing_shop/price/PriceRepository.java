package pl.sda.climbing_shop.price;

import org.springframework.data.repository.CrudRepository;
import pl.sda.climbing_shop.price.Price;

public interface PriceRepository extends CrudRepository<Price,Integer> {
}
