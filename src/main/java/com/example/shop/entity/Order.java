package com.example.shop.entity;

import com.example.shop.Status;
import com.example.shop.dto.View;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "orders")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @OneToMany (mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonView(View.Order.class)
  private List <Product> product = new ArrayList<>();
  @JsonView(View.Order.class)
  private String address;
  @JsonView(View.Order.class)
  private double priceOrder = priceOrder(product);
  @Enumerated(EnumType.STRING)
  @JsonView(View.Order.class)
  private Status status;
  @ManyToOne
  @JsonView(View.Order.class)
  private Customer customer;

  private static double priceOrder(List<Product> order) {
    if (order != null) {
      return order.stream().mapToDouble(Product::getAmount).sum();
    }
    return 0.;
  }
}
