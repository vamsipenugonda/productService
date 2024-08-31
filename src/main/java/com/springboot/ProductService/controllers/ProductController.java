package com.springboot.ProductService.controllers;

import com.springboot.ProductService.services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

   // public ProductController(@Qualifier("fakeStoreProductService") ProductService productService){}

    @PostMapping("/products")
    public void createProduct(){}

    @GetMapping("products/{id}")
    public String hi(@PathVariable("id") Long id){
        return id+"hi";
    }


}
