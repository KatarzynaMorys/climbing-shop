package pl.sda.climbing_shop.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.climbing_shop.address.Address;
import pl.sda.climbing_shop.address.AddressFormData;
import pl.sda.climbing_shop.address.AddressRepository;
import pl.sda.climbing_shop.customer.Customer;
import pl.sda.climbing_shop.customer.CustomerRepository;

@AllArgsConstructor
@Controller
public class ContactDetailsController {

    private final AddressRepository addressRepository;
    private final CustomerRepository customerRepository;

    @PostMapping("/addContactDetails")
    public String addContactDetails(AddressFormData formData, String phone, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Customer customer = this.customerRepository.findByEmail(authentication.getName()).orElseThrow();
        model.addAttribute("customer", customer);

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

        return "orderDetails";
    }
}
