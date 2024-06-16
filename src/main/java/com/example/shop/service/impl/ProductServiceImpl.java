package com.example.shop.service.impl;

import com.example.shop.dto.ProductCreateDto;
import com.example.shop.entity.Product;
import com.example.shop.mapper.ProductMapper;
import com.example.shop.repository.ProductRepository;
import com.example.shop.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;


@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;
  private final ProductMapper productMapper;
  private final ObjectMapper objectMapper;


  @Override
  public String createProduct(ProductCreateDto productCreateDto) throws JsonProcessingException {
    Product product = productMapper.productDtoToEntity(productCreateDto);
    productRepository.save(product);
    return objectMapper.writeValueAsString(product);
  }

  @Override
  @Transactional(readOnly = true)
  public List<Product> getProducts() {
    return productRepository.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public String getProductById(Long id) throws JsonProcessingException {
    Product product = productRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Продукт с id " + id + " не найден в магазине!"));
      return objectMapper.writeValueAsString(product);
    }

  @Override
  public Product updateProduct(Long id, ProductCreateDto productCreateDto) {
    Product product = productRepository.findById(id).orElseThrow();
    product.setProductName(productCreateDto.getProductName());
    product.setPrice(productCreateDto.getPrice());
    product.setDescription(productCreateDto.getDescription());
    product.setAmount(productCreateDto.getAmount());
    productRepository.save(product);
    return product;
  }

  @Override
  public boolean deleteProduct(Long id) {
    Product product = productRepository.findById(id).orElseThrow();
    if (productRepository.existsById(product.getId())) {
      productRepository.delete(product);
      return true;
    }
    return false;
  }
}

