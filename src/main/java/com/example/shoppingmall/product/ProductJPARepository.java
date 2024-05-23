package com.example.shoppingmall.product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ProductJPARepository extends JpaRepository<Product, Integer> {

    Optional<Product> findByProductId(int id);

    Page<Product> findAll(Pageable pageable);
    Page<Product> findByCategoryId(int categoryId, Pageable pageable);
}
