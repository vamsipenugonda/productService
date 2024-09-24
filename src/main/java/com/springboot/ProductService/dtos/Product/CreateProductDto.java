package com.springboot.ProductService.dtos.Product;

import com.springboot.ProductService.models.Category;
import com.springboot.ProductService.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductDto {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String imageUrl;
    private String categoryName;
    public CreateProductDto fromProduct(Product product) {
        CreateProductDto responseDto = new CreateProductDto();
        responseDto.setId(product.getId());
        responseDto.setDescription(product.getDescription());
        responseDto.setTitle(product.getTitle());
        responseDto.setPrice(product.getPrice());
        responseDto.setImageUrl(product.getImageURL());

        return responseDto;
    }
    public  Product toProduct(){
        Product product = new Product();
        product.setTitle(this.title);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setImageURL(this.imageUrl);
        Category category = new Category();
        category.setName(this.categoryName);
        product.setCategory(category);
        return product;
    }

}
