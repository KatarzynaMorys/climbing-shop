package pl.sda.climbing_shop.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.climbing_shop.configuration.UserDetailsServiceImplForCustomers;

@Controller
public class CustomerAccountController {

    @GetMapping("/account")
    public String getCustomerPanelView(
            Model model,
            @AuthenticationPrincipal UserDetailsServiceImplForCustomers.ClimbingShopUserDetails userDetails) {
        model.addAttribute("customer", userDetails);
        return "account";
    }
}
