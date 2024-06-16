package com.example.shop.service;

import com.example.shop.dto.CustomerDto;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface CustomerService {

  String createCustomer(CustomerDto customerDto) throws JsonProcessingException;
}
