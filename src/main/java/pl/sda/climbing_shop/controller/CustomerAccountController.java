package pl.sda.climbing_shop.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.climbing_shop.customer.Customer;
import pl.sda.climbing_shop.customer.CustomerRepository;
import pl.sda.climbing_shop.order.OrderRepository;
import pl.sda.climbing_shop.orders_products.OrdersProducts;
import pl.sda.climbing_shop.orders_products.OrdersProductsRepository;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Controller
public class CustomerAccountController {

    private final OrderRepository orderRepository;
    private final OrdersProductsRepository ordersProductsRepository;
    private final CustomerRepository customerRepository;

    @GetMapping("/account")
    public String getCustomerPanelView(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Customer customer = this.customerRepository.findByEmail(authentication.getName()).orElseThrow();
        model.addAttribute("customer", customer);

        List<OrdersProducts> orderedProducts = this.orderRepository.findOrdersByCustomerIs(customer).stream()
                .flatMap(order -> this.ordersProductsRepository.findByOrderIs(order).parallelStream())
                .collect(Collectors.toList());

        model.addAttribute("orderedProducts", orderedProducts);

        return "account";
    }
}