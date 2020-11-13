package pl.sda.climbing_shop.configuration;


import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import pl.sda.climbing_shop.address.Address;
import pl.sda.climbing_shop.customer.Customer;
import pl.sda.climbing_shop.customer.CustomerRepository;
import pl.sda.climbing_shop.order.Order;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private final CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Customer> optionalCustomer = this.customerRepository.findByEmail(username);
        Customer customer = optionalCustomer.orElseThrow(() -> new UsernameNotFoundException("Customer not found"));
        return ClimbingShopUserDetails.builder()
                .authorities(Collections.emptyList())
                .username(customer.getEmail())
                .password(customer.getHashPassword())
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .enabled(true)
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .phone(customer.getPhone())
                .address(customer.getAddress())
                .orders(customer.getOrders())
                .build();
    }

    @Getter
    @Builder
    public static class ClimbingShopUserDetails implements UserDetails {

        private Collection<GrantedAuthority> authorities;

        private String username;

        private String password;

        private boolean accountNonExpired;

        private boolean accountNonLocked;

        private boolean credentialsNonExpired;

        private boolean enabled;

        private String firstName;

        private String lastName;

        private String phone;

        private Address address;

        private List<Order> orders;
    }
}
