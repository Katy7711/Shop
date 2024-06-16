package com.example.shop.mapper;

import com.example.shop.dto.CustomerDto;
import com.example.shop.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper  (
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface CustomerMapper extends WebMapper<CustomerDto, Customer> {

    CustomerDto toCustomerDto(Customer entity);
    Customer customerDtoToEntity (CustomerDto dto);

}