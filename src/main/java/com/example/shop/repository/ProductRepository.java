package com.example.shop.repository;

import com.example.shop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
  boolean existsById(long id);
  Product findById(long id);

}
