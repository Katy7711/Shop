package com.example.shop.entity;

import com.example.shop.dto.View;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "products")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonView({View.Order.class})
  private Long id;
  @JsonView({View.Products.class, View.Order.class})
  private String productName;
  @JsonView({View.Products.class})
  private String description;
  @JsonView({View.Products.class})
  private double price;
  @JsonView({View.Products.class})
  private int amount;
  @ManyToOne
  private Order order;
}
