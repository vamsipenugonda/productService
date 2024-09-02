package com.springboot.ProductService.services;


import com.springboot.ProductService.exceptions.ProductNotFoundException;
import com.springboot.ProductService.models.Product;

import java.util.List;

public class ProductServiceFakestoreImpl implements ProductService{
    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product partialUpdateProduct(Long id, Product product) throws ProductNotFoundException {
        return null;
    }
   // Product particalUpdateProduct(Long id, Product product) throws ProductNotFoundException;
}
