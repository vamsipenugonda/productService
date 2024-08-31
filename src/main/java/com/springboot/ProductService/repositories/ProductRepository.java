package com.springboot.ProductService.repositories;

import com.springboot.ProductService.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Override
    Product save(Product product);

    @Override
    void delete(Product product);

    List<Product> findAll();

    @Override
    Optional<Product> findById(Long id);

    List<Product> findAllByCategory_Subcategories_SurnameEquals(String subcategorySurname);


}
