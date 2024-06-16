package com.example.shop.service.impl;

import com.example.shop.dto.CustomerDto;
import com.example.shop.entity.Customer;
import com.example.shop.mapper.CustomerMapper;
import com.example.shop.repository.CustomerRepository;
import com.example.shop.service.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

  private final CustomerRepository customerRepository;
  private final CustomerMapper customerMapper;
  private final ObjectMapper objectMapper;

  @Override
  public String createCustomer(CustomerDto customerDto) throws JsonProcessingException {
    if (customerRepository.existsByEmail(customerDto.getEmail())) {
      throw new ValidationException(
          String.format("Пользователь \"%s\" уже существует!", customerDto.getEmail()));
    }
    Customer createdCustomer = customerMapper.customerDtoToEntity(customerDto);
     customerRepository.save(createdCustomer);
     return objectMapper.writeValueAsString(createdCustomer);
  }
}
