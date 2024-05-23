package com.example.shoppingmall.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    @NotBlank(message = "상품 아이디는 필수 입력입니다.")
    private int id;

    @NotBlank(message = "상품 이름은 필수 입력입니다.")
    private String name;

    @NotNull(message = "상품 가격은 필수 입력입니다.")
    private int price;

    private String description;

    @NotNull(message = "상품 카테고리 아이디는 필수 입력입니다.")
    private int categoryId;

    public Product convertToEntity(){
        return new Product(id, name, price, description, categoryId);
    }
}
