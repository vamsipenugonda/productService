package com.springboot.ProductService.dtos.Product;

import com.springboot.ProductService.models.Product;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateProductResponseDto {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    public static CreateProductResponseDto fromProduct(Product product) {
        CreateProductResponseDto responseDto = new CreateProductResponseDto();
        responseDto.setId(product.getId());
        responseDto.setDescription(product.getDescription());
        responseDto.setTitle(product.getTitle());
        responseDto.setPrice(product.getPrice());
        responseDto.setImageUrl(product.getImageURL());

        return responseDto;
    }

}
