package com.springboot.ProductService.services;

import com.springboot.ProductService.exceptions.ProductNotFoundException;
import com.springboot.ProductService.models.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    List<Product> getAllProducts();
    Product partialUpdateProduct(Long id, Product product) throws ProductNotFoundException;
    Product getProduct(Long id);
     boolean deleteProduct(Long id) throws ProductNotFoundException;
    Product putProduct(Long id,Product product) throws ProductNotFoundException;
}
