package pl.sda.climbing_shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClimbingShopController {

    @GetMapping("/welcome")
    public String renderWelcomeScreen() {
        return "climbingShop";
    }

    @GetMapping("/home")
    public String returnHome() {
        return "home";
    }
}
