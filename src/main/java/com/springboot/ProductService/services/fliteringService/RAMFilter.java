package com.springboot.ProductService.services.fliteringService;

import com.springboot.ProductService.models.Product;

import java.util.ArrayList;
import java.util.List;

public class RAMFilter implements Filter {
     @Override
        public List<Product> apply(List<Product> products, List<String> allowedValues) {
            List<Product> ans = new ArrayList<>();

            for (Product product: products) {
                if (product.getDescription().contains("")) {
                    ans.add(product);
                }
            }

            return ans;
        }
    }

