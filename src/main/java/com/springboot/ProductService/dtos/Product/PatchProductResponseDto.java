package com.springboot.ProductService.dtos.Product;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PatchProductResponseDto {
    private GetProductDto product;
}
