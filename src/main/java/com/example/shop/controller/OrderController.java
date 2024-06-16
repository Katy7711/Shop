package com.example.shop.controller;

import com.example.shop.dto.OrderDto;
import com.example.shop.dto.View;
import com.example.shop.service.OrderService;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OrderController {

  private final OrderService orderService;

  @PostMapping("/order/add")
  public ResponseEntity<String> createOrder(@RequestBody OrderDto orderDto)
      throws JsonProcessingException {
    return ResponseEntity.ok(orderService.addOrder(orderDto));
  }

  @GetMapping("order/{id}")
  @JsonView(View.Order.class)
  public ResponseEntity<String> getOrderById(@PathVariable Long id) throws JsonProcessingException {
    return ResponseEntity.ok(orderService.getOrderById(id));
  }

}
