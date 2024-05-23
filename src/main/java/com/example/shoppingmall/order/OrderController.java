package com.example.shoppingmall.order;

import com.example.shoppingmall.product.Product;
import com.example.shoppingmall.product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class OrderController {

    OrderService orderService;
    ProductService productService;

    @PostMapping("/orders")
    public void orderProduct(@RequestBody OrderDTO orderDTO) {
        Product orderedProduct = productService.findProduct(orderDTO.getProductId());

        // DTO -> Entity
        Order requestOrder = new Order(orderedProduct, orderDTO.getCount());
        orderService.orderProduct(requestOrder);
    }
}
