package com.springboot.ProductService.repositories;

import com.springboot.ProductService.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
    @Override
    Product save(Product product);

    @Override
    void delete(Product product);
}
