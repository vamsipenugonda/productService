package com.springboot.ProductService.services.fliteringService;

import com.springboot.ProductService.models.Product;

import java.util.List;

public interface Filter {
    List<Product> apply(List<Product> products,List<String> allowedValues);
}
