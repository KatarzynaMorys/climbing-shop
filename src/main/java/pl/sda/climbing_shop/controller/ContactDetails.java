package pl.sda.climbing_shop.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import pl.sda.climbing_shop.address.Address;
import pl.sda.climbing_shop.address.AddressFormData;
import pl.sda.climbing_shop.address.AddressRepository;
import pl.sda.climbing_shop.customer.Customer;
import pl.sda.climbing_shop.customer.CustomerRepository;

@AllArgsConstructor
public class ContactDetails {

    private final AddressRepository addressRepository;
    private final CustomerRepository customerRepository;

    public void saveContactDetails(AddressFormData formData, String phone, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Customer customer = this.customerRepository.findByEmail(authentication.getName()).orElseThrow();

        customer.setPhone(phone);

        Address address = Address.builder()
                .state(formData.getState())
                .city(formData.getCity())
                .street(formData.getStreet())
                .streetNumber(formData.getStreetNumber())
                .postalCode(formData.getPostalCode())
                .build();
        if (this.addressRepository.findAddressByStateAndCityAndStreetAndStreetNumber(
                formData.getState(), formData.getCity(), formData.getStreet(), formData.getStreetNumber()).isEmpty()) {
            this.addressRepository.save(address);
            customer.setAddress(address);
        } else {
            Address addressFromDatabase = this.addressRepository.findAddressByStateAndCityAndStreetAndStreetNumber(
                    formData.getState(), formData.getCity(), formData.getStreet(), formData.getStreetNumber()).orElseThrow();
            customer.setAddress(addressFromDatabase);
        }

        this.customerRepository.save(customer);
        model.addAttribute("customer", customer);

    }
}
