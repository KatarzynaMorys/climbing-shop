package pl.sda.climbing_shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.climbing_shop.address.AddressFormData;
import pl.sda.climbing_shop.address.AddressRepository;
import pl.sda.climbing_shop.customer.Customer;
import pl.sda.climbing_shop.customer.CustomerRegistrationFormData;
import pl.sda.climbing_shop.customer.CustomerRepository;
import pl.sda.climbing_shop.role.RoleRepository;

@RequiredArgsConstructor
@Controller
public class CustomerRegistrationController {

    private final CustomerRepository customerRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    private final AddressRepository addressRepository;

    @GetMapping("/register")
    public String getRegistrationForm() {
        return "registrationForm";
    }

    @PostMapping("/register")
    public String registerCustomer(CustomerRegistrationFormData formData) {
        Customer customer = new Customer();
        customer.setFirstName(formData.getFirstName());
        customer.setLastName(formData.getLastName());
        customer.setEmail(formData.getEmail());
        customer.setHashPassword(this.passwordEncoder.encode(formData.getHashPassword()));
        customer.setRole(this.roleRepository.findRoleByNameIsLike("ROLE_USER").orElseThrow());
        this.customerRepository.save(customer);
        return "redirect:home";
    }

    @PostMapping("/changeName")
    public String changeName(String firstName, String lastName) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Customer customer = this.customerRepository.findByEmail(authentication.getName()).orElseThrow();

        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        this.customerRepository.save(customer);

        return "redirect:account";
    }

    @PostMapping("/changeEmail")
    public String changeEmail(String email) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Customer customer = this.customerRepository.findByEmail(authentication.getName()).orElseThrow();

        customer.setEmail(email);
        this.customerRepository.save(customer);

        Authentication newAuthentication = new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials());

        SecurityContextHolder.getContext().setAuthentication(newAuthentication);

        return "redirect:account";
    }

    @PostMapping("/changePassword")
    public String changePassword(CustomerRegistrationFormData formData) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Customer customer = this.customerRepository.findByEmail(authentication.getName()).orElseThrow();

        customer.setHashPassword(this.passwordEncoder.encode(formData.getHashPassword()));
        this.customerRepository.save(customer);

        return "redirect:account";
    }

    @PostMapping("/changeContactDetails")
    public String changeAddress(AddressFormData formData, String phone, Model model) {
        ContactDetails contactDetails = new ContactDetails(addressRepository, customerRepository);

        contactDetails.saveContactDetails(formData, phone, model);

        return "redirect:account";
    }
}
