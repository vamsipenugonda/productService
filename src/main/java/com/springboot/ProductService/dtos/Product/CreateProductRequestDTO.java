package com.springboot.ProductService.dtos.Product;

import com.springboot.ProductService.models.Category;
import com.springboot.ProductService.models.Product;

public class CreateProductRequestDTO {
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private String categoryName;

    public Product toProduct() {
        Product product = new Product();
        product.setTitle(this.title);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setImageURL(this.imageUrl);
        Category category = new Category();
        category.setName(categoryName);
        product.setCategory(category);

        return product;
    }
}
