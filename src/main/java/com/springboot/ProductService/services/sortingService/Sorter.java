package com.springboot.ProductService.services.sortingService;

import com.springboot.ProductService.models.Product;

import java.util.List;

public interface Sorter {
    List<Product> sort(List<Product> products);
}
