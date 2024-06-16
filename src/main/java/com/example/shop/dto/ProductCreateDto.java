package com.example.shop.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductCreateDto {
  @NotNull
  private String productName;
  @NotNull
  private String description;
  @NotNull
  private double price;
  private int amount;

}
