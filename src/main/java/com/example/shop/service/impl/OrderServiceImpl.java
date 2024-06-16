package com.example.shop.service.impl;

import com.example.shop.Status;
import com.example.shop.dto.OrderDto;
import com.example.shop.entity.Customer;
import com.example.shop.entity.Order;
import com.example.shop.entity.Product;
import com.example.shop.repository.CustomerRepository;
import com.example.shop.repository.OrderRepository;
import com.example.shop.repository.ProductRepository;
import com.example.shop.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

  private final OrderRepository orderRepository;
  private final CustomerRepository customerRepository;
  private final ProductRepository productRepository;
  private final ObjectMapper objectMapper;

  @Override
  public String addOrder(OrderDto orderDto) throws JsonProcessingException {
    List<Integer> list = orderDto.getProductId();
    List<Product> products = new ArrayList<>();
    for (Integer element : list) {
        Product product = productRepository.findById(element);
        if (product.getAmount() > 0) {
          products.add(product);
        }
      }
    Customer customer = customerRepository.findById(orderDto.getCustomerId()).orElseThrow();
    Order order = new Order();
    order.setProduct(products);
    order.setAddress(orderDto.getAddress());
    order.setStatus(Status.THE_ORDER_IS_BEING_PREPARED);
    order.setCustomer(customer);
    orderRepository.save(order);
    return objectMapper.writeValueAsString(order);
  }

  @Override
  @Transactional(readOnly = true)
  public String getOrderById(Long id) throws JsonProcessingException {
   Order order  = orderRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Заказ с id " + id + " не найден!"));
   return objectMapper.writeValueAsString(order);

  }
}
