package pl.sda.climbing_shop.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.climbing_shop.customer.Customer;
import pl.sda.climbing_shop.customer.CustomerRepository;
import pl.sda.climbing_shop.product.Product;
import pl.sda.climbing_shop.product.ProductFormData;
import pl.sda.climbing_shop.product.ProductRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Controller
public class ShoppingBagController {

    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

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

        Product product = this.productRepository.findById(productId).orElseThrow();

        if (session.getAttribute("shoppingBag") == null) {
            List<ProductFormData> shoppingBag = new ArrayList();
            buildOrderedProduct(productId, quantity, product, shoppingBag, session);
        } else {
            List<ProductFormData> shoppingBag = (List<ProductFormData>) session.getAttribute("shoppingBag");
            int index = getIndexOf(productId, shoppingBag);
            if (index == -1) {
                buildOrderedProduct(productId, quantity, product, shoppingBag, session);
            } else {
                Integer newQuantity = shoppingBag.get(index).getQuantity() + quantity;
                Integer checkedQuantity = reduceToQuantityInStore(newQuantity, product.getQuantity());
                shoppingBag.get(index).setQuantity(checkedQuantity);

                if (newQuantity > checkedQuantity) {
                    shoppingBag.get(index).setMessage("Unfortunately, the following quantity of item(s) that you ordered are now out-of-stock." +
                            "We have " + product.getQuantity() + " item(s) in stock.");
                }
            }
            session.setAttribute("shoppingBag", shoppingBag);
        }

        model.addAttribute("totalPrice", totalPrice(session));

        return "shoppingBag";
    }

    private void buildOrderedProduct(@PathVariable("productId") Integer productId,
                                     @RequestParam("quantity") Integer orderedQuantity,
                                     Product product, List<ProductFormData> shoppingBag,
                                     HttpSession session) {
        ProductFormData formData = ProductFormData.builder()
                .productId(productId)
                .image(product.getImage())
                .brandName(product.getBrand().getBrandName())
                .productName(product.getProductName())
                .productType(product.getProductType())
                .productColor(product.getProductColor())
                .productSize(product.getProductSize())
                .basePrice(product.getPrice().getBasePrice())
                .discountValue(product.getPrice().getDiscountValue())
                .quantity(orderedQuantity)
                .quantityInStore(product.getQuantity())
                .build();

        shoppingBag.add(formData);
        session.setAttribute("shoppingBag", shoppingBag);
    }

    @PostMapping("/update/{productId}")
    public String update(@PathVariable("productId") Integer productId,
                         HttpServletRequest request,
                         HttpSession session, Model model) {
        List<ProductFormData> shoppingBag = (List<ProductFormData>) session.getAttribute("shoppingBag");
        int index = getIndexOf(productId, shoppingBag);
        shoppingBag.get(index).setQuantity(Integer.parseInt(request.getParameter("quantity")));
        shoppingBag.get(index).setMessage(null);
        session.setAttribute("shoppingBag", shoppingBag);
        model.addAttribute("totalPrice", totalPrice(session));
        return "shoppingBag";
    }

    @GetMapping("/delete/{productId}")
    public String delete(@PathVariable("productId") Integer productId,
                         HttpSession session, Model model) {
        List<ProductFormData> shoppingBag = (List<ProductFormData>) session.getAttribute("shoppingBag");
        int index = getIndexOf(productId, shoppingBag);
        shoppingBag.remove(index);
        session.setAttribute("shoppingBag", shoppingBag);
        model.addAttribute("totalPrice", totalPrice(session));

        return "shoppingBag";
    }

    @GetMapping("/checkout")
    public String checkout(Model model, HttpSession session) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getName().equals("anonymousUser")) {
            return "login";
        } else {
            Customer customer = this.customerRepository
                    .findByEmail(authentication.getName())
                    .orElseThrow();
            model.addAttribute("customer", customer);
            model.addAttribute("totalPrice", totalPrice(session));
            return "orderDetails";
        }
    }

    private Integer reduceToQuantityInStore(Integer orderedQuantity, Integer storedQuantity) {
        if (orderedQuantity > storedQuantity)
            return storedQuantity;
        else {
            return orderedQuantity;
        }
    }

    private int getIndexOf(int productId, List<ProductFormData> shoppingBag) {
        for (int i = 0; i < shoppingBag.size(); i++) {
            if (shoppingBag.get(i).getProductId() == productId) {
                return i;
            }
        }
        return -1;
    }

    private double totalPrice(HttpSession session) {
        List<ProductFormData> shoppingBag = (List<ProductFormData>) session.getAttribute("shoppingBag");
        double totalPrice = 0;
        for (ProductFormData product : shoppingBag) {
            if (product.getDiscountValue() == null) {
                product.setDiscountValue(0);
            }
            totalPrice += product.getQuantity() * product.getBasePrice()
                    * (100 - product.getDiscountValue()) / 100;
        }
        return totalPrice;
    }

}
