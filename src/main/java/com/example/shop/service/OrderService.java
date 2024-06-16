package com.example.shop.service;

import com.example.shop.dto.OrderDto;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface OrderService {

  String addOrder(OrderDto orderDto) throws JsonProcessingException;

  String getOrderById(Long id) throws JsonProcessingException;
}
