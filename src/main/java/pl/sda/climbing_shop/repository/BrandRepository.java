package pl.sda.climbing_shop.repository;

import org.springframework.data.repository.CrudRepository;
import pl.sda.climbing_shop.entity.Brand;

public interface BrandRepository extends CrudRepository<Brand,Integer> {
}
