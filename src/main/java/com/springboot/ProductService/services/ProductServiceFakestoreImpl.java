package com.springboot.ProductService.services;


import com.springboot.ProductService.dtos.FakeStore.FakeStoreCreateProductRequestDTO;
import com.springboot.ProductService.dtos.FakeStore.FakeStoreGetProductResponseDTO;
import com.springboot.ProductService.exceptions.ProductNotFoundException;
import com.springboot.ProductService.models.Product;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ProductServiceFakestoreImpl implements ProductService{
    private RestTemplate restTemplate;

    public ProductServiceFakestoreImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public Product createProduct(Product product) {
        FakeStoreCreateProductRequestDTO request = new FakeStoreCreateProductRequestDTO();
        request.setCategory(product.getCategory().getName());
        request.setTitle(product.getTitle());
        request.setDescription(product.getDescription());
        request.setPrice(product.getPrice());

        FakeStoreGetProductResponseDTO response = restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                request,
                FakeStoreGetProductResponseDTO.class
        );
        return response.toProduct();

    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product partialUpdateProduct(Long id, Product product) throws ProductNotFoundException {
        return null;
    }

    @Override
    public Product getProduct(Long id) {
        return null;
    }

    @Override
    public boolean deleteProduct(Long id) throws ProductNotFoundException {
        return false;
    }

    @Override
    public Product putProduct(Long id, Product product) throws ProductNotFoundException {
        return null;
    }

}
