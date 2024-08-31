package com.springboot.ProductService.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class SubCategory extends BaseModel{
    private String name;

}
