package pl.sda.climbing_shop.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.climbing_shop.address.AddressFormData;
import pl.sda.climbing_shop.address.AddressRepository;
import pl.sda.climbing_shop.customer.CustomerRepository;

@AllArgsConstructor
@Controller
public class ContactDetailsController {

    private final AddressRepository addressRepository;

    private final CustomerRepository customerRepository;

    @PostMapping("/addContactDetails")
    public String addContactDetails(AddressFormData formData, String phone, Model model) {
        ContactDetails contactDetails = new ContactDetails(addressRepository, customerRepository);

        contactDetails.saveContactDetails(formData, phone, model);
        return "orderDetails";
    }


}
