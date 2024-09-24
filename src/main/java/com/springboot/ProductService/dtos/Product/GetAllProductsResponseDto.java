package com.springboot.ProductService.dtos.Product;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class GetAllProductsResponseDto {
    public List<GetProductDto> products;
}
