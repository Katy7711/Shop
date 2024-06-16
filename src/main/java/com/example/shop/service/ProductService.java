package com.example.shop.service;

import com.example.shop.dto.ProductCreateDto;
import com.example.shop.entity.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;

public interface ProductService {

  String createProduct(ProductCreateDto productCreateDto) throws JsonProcessingException;

  List<Product> getProducts();

  String getProductById(Long id) throws JsonProcessingException;

  Product updateProduct(Long id, ProductCreateDto productCreateDto);

  boolean deleteProduct(Long id);
}
