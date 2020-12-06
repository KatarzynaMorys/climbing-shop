package pl.sda.climbing_shop.orders_products;

import lombok.Data;
import pl.sda.climbing_shop.order.Order;
import pl.sda.climbing_shop.product.Product;

import javax.persistence.*;

@Data
@Entity
@Table(name = "orders_products")
public class OrdersProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ordersProductsId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
