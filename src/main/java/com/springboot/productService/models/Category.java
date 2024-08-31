package com.springboot.productService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel{
    private String name;
    private String description;
    @OneToMany
    private List<Product> featureProducts;
    @OneToMany(mappedBy = "category")
    private List<Product> allProduct;
}
