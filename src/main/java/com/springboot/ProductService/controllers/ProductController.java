package com.springboot.ProductService.controllers;

import com.springboot.ProductService.dtos.Product.*;
import com.springboot.ProductService.exceptions.ProductNotFoundException;
import com.springboot.ProductService.models.Product;
import com.springboot.ProductService.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(@Qualifier("dbProductService") ProductService productService){
        this.productService = productService;
    }
    @PostMapping("/products")
    public CreateProductResponseDTO createProduct(@RequestBody CreateProductRequestDTO createProductRequestDTO){
        Product product = productService.createProduct(createProductRequestDTO.toProduct());
        return CreateProductResponseDTO.fromProduct(product);
    }

    @GetMapping("")
    public GetAllProductsResponseDTO getAllProducts(){
        List<Product> products = productService.getAllProducts();
        GetAllProductsResponseDTO response = new GetAllProductsResponseDTO();

        List<GetProductDTO> getProductResponseDtos = new ArrayList<>();

        for (Product product: products) {
            getProductResponseDtos.add(GetProductDTO.from(product));
        }

        response.setProducts(getProductResponseDtos);

        return response;
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id){
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
    }

    @PatchMapping("/{id}")
    public PatchProductResponseDTO updateProduct(
            @PathVariable Long productId,
            @RequestBody CreateProductDTO productDto) throws ProductNotFoundException
    {
        Product product = productService.partialUpdateProduct(
                productId,
                productDto.toProduct()
        );
        PatchProductResponseDTO response = new PatchProductResponseDTO();
        response.setProduct(GetProductDTO.from(product));

        return response;
    }

    @PutMapping("/{id}")
    public void putProduct(
            @PathVariable Long id,
            @RequestBody CreateProductDTO createProductDTO) throws ProductNotFoundException
    {
    }
}
/*
* post-done
* getAll-done
* getId
* delete
* patch-done
* put
* */
