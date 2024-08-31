package com.springboot.ProductService.services;

import com.springboot.ProductService.exceptions.ProductNotFoundException;
import com.springboot.ProductService.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("dbProductService")
public class ProductServiceDBImpl implements ProductService {
    @Override
    public Product crateProduct(Product product) {
        return null;
    }

    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public Product particalUpdateProduct(Long id, Product product) throws ProductNotFoundException {
        return null;
    }
}
