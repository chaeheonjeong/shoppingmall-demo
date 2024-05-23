package com.example.shoppingmall.order;

import com.example.shoppingmall.product.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class Order {
    int id;
    Product product; // Domain = Object
    int count;

    public Order(Product orderedProduct, int count){
        this.product = orderedProduct;
        this.count = count;
    }
}
