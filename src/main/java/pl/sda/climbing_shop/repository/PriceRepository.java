package pl.sda.climbing_shop.repository;

import org.springframework.data.repository.CrudRepository;
import pl.sda.climbing_shop.entity.Price;

public interface PriceRepository extends CrudRepository<Price,Integer> {
}
