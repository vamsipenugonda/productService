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
    public GetProductDTO getProduct(@PathVariable Long id){
        Product product=productService.getProduct(id);
        if(product!=null){
            return GetProductDTO.from(product);
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
    public ResponseEntity<Product> putProduct(
            @PathVariable Long id,
            @RequestBody CreateProductDTO createProductDTO) throws ProductNotFoundException
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
