package pl.sda.climbing_shop.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.climbing_shop.brand.Brand;
import pl.sda.climbing_shop.customer.Customer;
import pl.sda.climbing_shop.customer.CustomerRepository;
import pl.sda.climbing_shop.order.Order;
import pl.sda.climbing_shop.order.OrderRepository;
import pl.sda.climbing_shop.orders_products.OrdersProducts;
import pl.sda.climbing_shop.orders_products.OrdersProductsRepository;
import pl.sda.climbing_shop.price.Price;
import pl.sda.climbing_shop.product.Product;
import pl.sda.climbing_shop.product.ProductFormData;
import pl.sda.climbing_shop.product.ProductRepository;

import javax.servlet.http.HttpSession;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Controller
public class OrderController {

    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private final OrdersProductsRepository ordersProductsRepository;
    private final ProductRepository productRepository;

    @GetMapping("/order")
    public String order(HttpSession session, Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Order order = new Order();

        Customer customer = this.customerRepository
                .findByEmail(authentication.getName())
                .orElseThrow();
        order.setCustomer(customer);

        order.setOrderStatus("In progress");

        LocalDate now = LocalDate.now();
        order.setOrderDate(now);
        LocalDate deliveryDate = addDaysSkippingWeekends(now, 3);
        order.setDeliveryDate(deliveryDate);

        List<ProductFormData> shoppingBag = (List<ProductFormData>) session.getAttribute("shoppingBag");
        List<Product> shoppingBagProductList = mapToProductList(shoppingBag);
        order.setProducts(shoppingBagProductList);

        this.orderRepository.save(order);

        for (int i = 0; i < shoppingBag.size(); i++) {
            OrdersProducts ordersProducts = new OrdersProducts();
            ordersProducts.setOrder(order);
            ordersProducts.setProduct(shoppingBagProductList.get(i));
            this.ordersProductsRepository.save(ordersProducts);

            Product product = this.productRepository.findById(shoppingBag.get(i).getProductId()).orElseThrow();
            product.setQuantity(product.getQuantity() - shoppingBag.get(i).getQuantity());
            this.productRepository.save(product);
        }

        session.removeAttribute("shoppingBag");
        model.addAttribute("customer", customer);

        return "thanks";
    }

    private List<Product> mapToProductList(List<ProductFormData> shoppingBag) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < shoppingBag.size(); i++) {
            ProductFormData productFormData = shoppingBag.get(i);
            Product product = Product.builder()
                    .productId(productFormData.getProductId())
                    .image(productFormData.getImage())
                    .brand(Brand
                            .builder()
                            .brandName(productFormData.getBrandName())
                            .build())
                    .productName(productFormData.getProductName())
                    .productType(productFormData.getProductType())
                    .productColor(productFormData.getProductColor())
                    .productSize(productFormData.getProductSize())
                    .price(Price.builder()
                            .basePrice(productFormData.getBasePrice())
                            .discountValue(productFormData.getDiscountValue())
                            .build())
                    .quantity(productFormData.getQuantity())
                    .build();
            products.add(product);
        }
        return products;
    }

    public static LocalDate addDaysSkippingWeekends(LocalDate date, int days) {
        LocalDate result = date;
        int addedDays = 0;
        while (addedDays < days) {
            result = result.plusDays(1);
            if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                ++addedDays;
            }
        }
        return result;
    }
}
