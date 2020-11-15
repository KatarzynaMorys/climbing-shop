package pl.sda.climbing_shop.configuration;


import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import pl.sda.climbing_shop.employee.Employee;
import pl.sda.climbing_shop.employee.EmployeeRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class UserDetailsServiceImplForEmployees implements UserDetailsService {

    private final EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Employee> optionalEmployee = this.employeeRepository.findByEmail(username);
        Employee employee = optionalEmployee.orElseThrow(() -> new UsernameNotFoundException("Employee not found"));

        return ClimbingShopUserDetails.builder()
                .authorities(List.of(employee.getRole().getName()).stream()
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList()))
                .username(employee.getEmail())
                .password(employee.getHashPassword())
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .enabled(true)
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
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

    }
}
