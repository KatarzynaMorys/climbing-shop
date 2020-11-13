package pl.sda.climbing_shop.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;

@ControllerAdvice
public class UserControllerAdvice {
    @ModelAttribute("username")
    public String username(Principal principal) {
        return principal == null ? null : principal.getName();
    }
}
