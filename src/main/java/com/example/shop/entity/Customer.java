package com.example.shop.entity;

import static com.example.shop.Constant.EMAIL_REGEXP;
import static com.example.shop.Constant.PHONE_REGEXP;

import com.example.shop.dto.View;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "customers")
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonView(View.Order.class)
  private Long id;
  @JsonView(View.Order.class)
  private String costumerFullName;
  @Email(regexp = EMAIL_REGEXP)
  @Schema(example = "user@user.ru")private String email;
  @Pattern(regexp = PHONE_REGEXP)
  private String numberOfPhone;



}
