package com.springboot.ProductService.dtos.Product;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class GetAllProductsResponseDTO {
    public List<GetProductDTO> products;
}
