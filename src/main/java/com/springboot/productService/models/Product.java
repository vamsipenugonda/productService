package com.springboot.productService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private Long id;
    private String title;
    private String description;
    private double price;
    private String imageURL;
    @ManyToOne
    private Category categoryName;
}
