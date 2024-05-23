package com.example.shoppingmall.product;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor // 필드로 생성자 코드 구현
public class ProductService {
    @Autowired
    ProductJPARepository productJPARepository;

    public Product registerProduct(Product product) {
        System.out.println(
                "/products : service - " + product.getName());

        return productJPARepository.save(product);
    }

    public Optional<Product> findProduct(int id) {
        return productJPARepository.findByProductId(id);
    }

    public List<Product> findProducts(int limit, int currentPage) {

        Pageable pageable = PageRequest.of(currentPage, limit);
        Page<Product> productPage = productJPARepository.findAll();
        return productRepository.findProducts(limit, currentPage);
    }

    public List<Product> findProducts(int limit, int currentPage, int categoryId) {
        return productRepository.findProducts(limit, currentPage, categoryId);
    }

//    public void deleteProduct(int id) {
//        productRepository.deleteProduct(id);
//    }
//
//    public void deleteProducts(List<Integer> productIds) {
//        productRepository.deleteProducts(productIds);
//    }
}
