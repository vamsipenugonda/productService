package com.springboot.ProductService.repositories;

import com.springboot.ProductService.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {

}
