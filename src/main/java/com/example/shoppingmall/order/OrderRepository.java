package com.example.shoppingmall.order;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@Slf4j
public class OrderRepository {
    private final Map<Integer, Order> orderTable = new HashMap<>();
    private int id = 0;

    public void createOrder(Order order){
        log.info("productName={}", order.getProduct().getName());

        order.setId(id++);
        orderTable.put(order.getId(), order);
    }
}
