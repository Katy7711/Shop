package com.example.shop.dto;

import static com.example.shop.Constant.EMAIL_REGEXP;
import static com.example.shop.Constant.PHONE_REGEXP;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CustomerDto {

  private String costumerFullName;
  @Email(regexp = EMAIL_REGEXP)
  @Schema(example = "user@user.ru")private String email;
  @Pattern(regexp = PHONE_REGEXP)
  private String numberOfPhone;

}
