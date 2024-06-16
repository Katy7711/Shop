package com.example.shop.mapper;


import com.example.shop.dto.OrderDto;
import com.example.shop.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface OrderMapper extends WebMapper<OrderDto, Order> {

  OrderDto toOrderDto(Order entity);

  Order orderDtoToEntity (OrderDto dto);
}
