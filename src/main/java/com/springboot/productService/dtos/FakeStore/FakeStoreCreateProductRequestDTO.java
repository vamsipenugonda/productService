package com.springboot.productService.dtos.FakeStore;

import com.springboot.productService.models.Product;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreCreateProductRequestDTO {
    private String title;
    private double price;
    private String image;
    private String description;
    private String category;
    public static FakeStoreCreateProductRequestDTO fromProduct(Product product){
        FakeStoreCreateProductRequestDTO fakeStoreCreateProductRequestDTO= new FakeStoreCreateProductRequestDTO();
        fakeStoreCreateProductRequestDTO.setTitle(product.getTitle());
        fakeStoreCreateProductRequestDTO.setPrice(product.getPrice());
        fakeStoreCreateProductRequestDTO.setImage(product.getImageURL());
        fakeStoreCreateProductRequestDTO.setDescription(product.getDescription());
        fakeStoreCreateProductRequestDTO.setCategory(product.getCategoryName());
        return fakeStoreCreateProductRequestDTO;
    }
}
