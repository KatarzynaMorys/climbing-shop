package pl.sda.climbing_shop.address;

import lombok.Data;

@Data
public class AddressFormData {

    private String state;

    private String city;

    private String street;

    private String streetNumber;

    private String postalCode;
}
