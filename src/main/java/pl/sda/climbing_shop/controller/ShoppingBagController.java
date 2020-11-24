package pl.sda.climbing_shop.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.climbing_shop.product.Product;
import pl.sda.climbing_shop.product.ProductRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Controller
public class ShoppingBagController {

    private final ProductRepository productRepository;

    @GetMapping("/shoppingBag")
    public String viewShoppingBag(Model model, HttpSession session) {
        if (session.getAttribute("shoppingBag") == null) {
            model.addAttribute("totalPrice", 0.0);
        } else model.addAttribute("totalPrice", totalPrice(session));
        return "shoppingBag";
    }

    @GetMapping("/addToShoppingBag/{productId}")
    public String addProductToShoppingBag(@PathVariable("productId") Integer productId,
                                          @RequestParam("quantity") Integer quantity,
                                          Model model, HttpSession session) {

        model.addAttribute("productRepository", productRepository);

        if (session.getAttribute("shoppingBag") == null) {
            List<Product> shoppingBag = new ArrayList();
            Product product = productRepository.findById(productId).orElseThrow();
            product.setQuantity(quantity);
            shoppingBag.add(product);
            session.setAttribute("shoppingBag", shoppingBag);
        } else {
            List<Product> shoppingBag = (List<Product>) session.getAttribute("shoppingBag");
            int index = getIndexOf(productId, shoppingBag);
            if (index == -1) {
                Product product = productRepository.findById(productId).orElseThrow();
                product.setQuantity(quantity);
                shoppingBag.add(product);
            } else {
                int newQuantity = shoppingBag.get(index).getQuantity() + quantity;
                shoppingBag.get(index).setQuantity(newQuantity);
            }
            session.setAttribute("shoppingBag", shoppingBag);
        }

        model.addAttribute("totalPrice", totalPrice(session));

        return "shoppingBag";
    }

    @PostMapping("/update/{productId}")
    public String update(@PathVariable("productId") Integer productId,
                         HttpServletRequest request,
                         HttpSession session, Model model) {
        List<Product> shoppingBag = (List<Product>) session.getAttribute("shoppingBag");
        int index = getIndexOf(productId, shoppingBag);
        shoppingBag.get(index).setQuantity(Integer.parseInt(request.getParameter("quantity")));
        session.setAttribute("shoppingBag", shoppingBag);
        model.addAttribute("totalPrice", totalPrice(session));
        return "shoppingBag";
    }

    @GetMapping("/delete/{productId}")
    public String delete(@PathVariable("productId") Integer productId,
                         HttpSession session, Model model) {
        List<Product> shoppingBag = (List<Product>) session.getAttribute("shoppingBag");
        int index = getIndexOf(productId, shoppingBag);
        shoppingBag.remove(index);
        session.setAttribute("shoppingBag", shoppingBag);
        model.addAttribute("totalPrice", totalPrice(session));

        return "shoppingBag";
    }

    @GetMapping("/checkout")
    public String checkout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getName().equals("anonymousUser")) {
            return "login";
        } else return "orderDetails";
    }

    private int getIndexOf(int productId, List<Product> shoppingBag) {
        for (int i = 0; i < shoppingBag.size(); i++) {
            if (shoppingBag.get(i).getProductId() == productId) {
                return i;
            }
        }
        return -1;
    }

    private double totalPrice(HttpSession session) {
        List<Product> shoppingBag = (List<Product>) session.getAttribute("shoppingBag");
        double totalPrice = 0;
        for (Product product : shoppingBag) {
            if (product.getPrice().getDiscountValue() == null) {
                product.getPrice().setDiscountValue(0);
            }
            totalPrice += product.getQuantity() * product.getPrice().getBasePrice()
                    * (100 - product.getPrice().getDiscountValue()) / 100;
        }
        return totalPrice;
    }

}
