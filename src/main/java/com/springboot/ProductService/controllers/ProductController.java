package com.springboot.ProductService.controllers;

import com.springboot.ProductService.dtos.Product.*;
import com.springboot.ProductService.exceptions.ProductNotFoundException;
import com.springboot.ProductService.models.Product;
import com.springboot.ProductService.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
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
    public CreateProductResponseDto createProduct(@RequestBody CreateProductRequestDto createProductRequestDTO){
        Product product = productService.createProduct(createProductRequestDTO.toProduct());
        return CreateProductResponseDto.fromProduct(product);
    }

    @GetMapping("")
    public GetAllProductsResponseDto getAllProducts(){
        List<Product> products = productService.getAllProducts();
        GetAllProductsResponseDto response = new GetAllProductsResponseDto();

        List<GetProductDto> getProductResponseDtos = new ArrayList<>();

        for (Product product: products) {
            getProductResponseDtos.add(GetProductDto.from(product));
        }

        response.setProducts(getProductResponseDtos);

        return response;
    }

    @GetMapping("/{id}")
    public GetProductDto getProduct(@PathVariable Long id){
        Product product=productService.getProduct(id);
        if(product!=null){
            return GetProductDto.from(product);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public Boolean deleteProduct(@PathVariable Long id) throws ProductNotFoundException {
        if(productService.deleteProduct(id)){
            return true;
        }
        return false;
    }

    @PatchMapping("/{id}")
    public PatchProductResponseDto updateProduct(
            @PathVariable Long productId,
            @RequestBody CreateProductDto productDto) throws ProductNotFoundException
    {
        Product product = productService.partialUpdateProduct(
                productId,
                productDto.toProduct()
        );
        PatchProductResponseDto response = new PatchProductResponseDto();
        response.setProduct(GetProductDto.from(product));

        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> putProduct(
            @PathVariable Long id,
            @RequestBody CreateProductDto createProductDTO) throws ProductNotFoundException
    {
        Product product =productService.putProduct(id, createProductDTO.toProduct());
        return ResponseEntity.ok(product);
    }
}
/*
* post-done
* getAll-done
* getId-done
* delete-done
* patch-done
* put-done
* */
