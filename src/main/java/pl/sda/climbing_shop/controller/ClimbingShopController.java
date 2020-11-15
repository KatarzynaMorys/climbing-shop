package pl.sda.climbing_shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClimbingShopController {

    @GetMapping("/home")
    public String returnHome() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/shoppingBag")
    public String viewShoppingBag() {
        return "shoppingBag";
    }

    @GetMapping("/contact")
    public String viewContactDetails() {
        return "contact";
    }

    @GetMapping("/FAQs")
    public String viewFAQS() {
        return "FAQs";
    }

    @GetMapping("/returns")
    public String viewReturnPolicy() {
        return "returns";
    }
}
