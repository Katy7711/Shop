package com.example.shop.dto;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.Data;

@Data
public class OrderDto {

  @NotNull
  private List<Integer> productId;
  @NotNull
  private String address;
  @NotNull
  private long customerId;

}
