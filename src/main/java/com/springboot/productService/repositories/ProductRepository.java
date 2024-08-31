package com.springboot.productService.repositories;

import com.springboot.productService.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
    @Override
    Product save(Product product);

    @Override
    void delete(Product product);
}
