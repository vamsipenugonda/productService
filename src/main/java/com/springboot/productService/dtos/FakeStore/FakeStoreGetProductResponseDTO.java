package com.springboot.productService.dtos.FakeStore;

import com.springboot.productService.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreGetProductResponseDTO {
    private Long id;
    private String title;
    private double price;
    private String image;
    private String description;
    private String category;
    public Product toProduct(){
        Product product = new Product();
        product.setId(this.getId());
        product.setTitle(this.getTitle());
        product.setPrice(this.getPrice());
        product.setImageURL(this.getImage());
        product.setDescription(this.getDescription());
        product.setCategoryName(this.getCategory());
        return product;
    }
}
