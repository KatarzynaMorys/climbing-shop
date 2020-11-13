package pl.sda.climbing_shop.customer;

import lombok.Data;

@Data
public class CustomerRegistrationFormData {

    private String firstName;

    private String lastName;

    private String email;

    private String hashPassword;
}
