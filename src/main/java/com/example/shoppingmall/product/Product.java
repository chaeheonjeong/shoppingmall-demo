package com.example.shoppingmall.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Product {
    @Id
    private int id;
    private String name;
    private int price;
    private String description;
    private int categoryId;

    public Product() {
    }
}
