package com.springboot.ProductService.services.fliteringService;

import com.springboot.ProductService.models.Product;

import java.util.List;
import java.util.stream.Collectors;

public class BrandFilter implements Filter {
    @Override
    public List<Product> apply(List<Product> products, List<String> allowedValues) {
        return List.of();
    }
}
