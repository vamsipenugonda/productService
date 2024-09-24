package com.springboot.ProductService.dtos.Search;

import com.springboot.ProductService.dtos.Product.GetProductDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
@Setter
@Getter
public class SearchResponseDto {
    private Page<GetProductDto> productsPage;
}
