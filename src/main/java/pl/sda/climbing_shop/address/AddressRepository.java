package pl.sda.climbing_shop.address;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AddressRepository extends CrudRepository<Address, Integer> {

    Optional<Address> findAddressByStateAndCityAndStreetAndStreetNumber(
            String state, String city, String street, String streetNumber);
}
