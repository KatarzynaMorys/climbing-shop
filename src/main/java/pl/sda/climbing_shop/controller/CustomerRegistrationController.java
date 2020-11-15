package pl.sda.climbing_shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.climbing_shop.customer.Customer;
import pl.sda.climbing_shop.customer.CustomerRegistrationFormData;
import pl.sda.climbing_shop.customer.CustomerRepository;
import pl.sda.climbing_shop.role.Role;
import pl.sda.climbing_shop.role.RoleRepository;

import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class CustomerRegistrationController {

    private final CustomerRepository customerRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

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
        Optional<Role> optionalRole = this.roleRepository.findById(1);
        customer.setRole(optionalRole.orElseThrow());
        this.customerRepository.save(customer);
        return "redirect:home";
    }

}
