package com.example.shop.controller;

import com.example.shop.dto.CustomerDto;
import com.example.shop.service.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CostumerController {

  private final CustomerService customerService;


  @PostMapping("/add/customer")
  public ResponseEntity<String> addUser(@RequestBody CustomerDto customerDto)
      throws JsonProcessingException {
    return ResponseEntity.ok(customerService.createCustomer(customerDto));
  }
}
