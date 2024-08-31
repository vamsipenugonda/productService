package com.springboot.ProductService.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel{
    @Column(unique = true, nullable = false,name="category_name")
    private String name;
    @Basic(fetch = FetchType.LAZY)
    private String description;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    //@Basic(fetch = FetchMode.SELECT)
    private List<Product> featureProducts;
    @OneToMany(mappedBy = "category")
    private List<Product> allProduct;
    @OneToOne(cascade = {})
    private SubCategory subcategories;
    private int countOfProducts;
}
