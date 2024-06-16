package com.example.shop.mapper;

import com.example.shop.dto.ProductCreateDto;
import com.example.shop.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ProductMapper extends WebMapper<ProductCreateDto, Product> {
  ProductCreateDto toProductDto(Product entity);
  Product productDtoToEntity (ProductCreateDto dto);

}
