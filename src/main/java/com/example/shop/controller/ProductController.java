package com.example.shop.controller;

import com.example.shop.dto.ProductCreateDto;
import com.example.shop.dto.View;
import com.example.shop.entity.Product;
import com.example.shop.service.ProductService;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ProductController {

  private final ProductService productService;


  @PostMapping("/add/product")
  public ResponseEntity<String> addProduct(@RequestBody ProductCreateDto productCreateDto) throws JsonProcessingException {
    return ResponseEntity.ok(productService.createProduct(productCreateDto));
  }

  @GetMapping("/products")
  @JsonView({View.Products.class})
  public ResponseEntity<List<Product>> getProducts() {
    return ResponseEntity.ok(productService.getProducts());
  }

  @GetMapping("product/{id}")
  @JsonView(View.Products.class)
  public ResponseEntity<String> getProductById(@PathVariable Long id)
      throws JsonProcessingException {
    return ResponseEntity.ok(productService.getProductById(id));
  }

  @PatchMapping("/update/product")
  @JsonView(View.Products.class)
  public ResponseEntity<Product> updateProduct(Long id,
      @Valid @RequestBody ProductCreateDto productCreateDto) {
    return ResponseEntity.ok(productService.updateProduct(id, productCreateDto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> removeProduct(@PathVariable Long id) {
    if (productService.deleteProduct(id)) {
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.status(HttpServletResponse.SC_NOT_FOUND).build();
  }
}
