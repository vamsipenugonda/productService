package com.springboot.ProductService.services;

import com.springboot.ProductService.exceptions.ProductNotFoundException;
import com.springboot.ProductService.models.Product;

import java.util.List;

public interface ProductService {
    Product crateProduct(Product product);
    List<Product> getProducts();
    Product particalUpdateProduct(Long id, Product product) throws ProductNotFoundException;
}
