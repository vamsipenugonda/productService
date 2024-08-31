package com.springboot.ProductService.controllers;

import com.springboot.ProductService.dtos.Product.CreateProductDTO;
import com.springboot.ProductService.dtos.Product.GetAllResponseDTO;
import com.springboot.ProductService.dtos.Product.PatchProductResponseDTO;
import com.springboot.ProductService.exceptions.ProductNotFoundException;
import com.springboot.ProductService.models.Product;
import com.springboot.ProductService.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(@Qualifier("dbProductService")ProductService productService){
        this.productService = productService;
    }
    @PostMapping("/products")
    public void createProduct(@RequestBody CreateProductDTO createProductDTO){
    }

    @GetMapping("")
    public GetAllResponseDTO getAllProducts(){
        return null;
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id){
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
    }

    @PatchMapping("/{id}")
    public PatchProductResponseDTO patchProduct(
            @PathVariable Long id,

            @RequestBody CreateProductDTO createProductDTO) throws ProductNotFoundException
    {
        return null;
    }

    @PutMapping("/{id}")
    public void putProduct(
            @PathVariable Long id,
            @RequestBody CreateProductDTO createProductDTO) throws ProductNotFoundException
    {
    }


}
