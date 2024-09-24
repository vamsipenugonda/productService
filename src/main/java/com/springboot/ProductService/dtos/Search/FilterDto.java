package com.springboot.ProductService.dtos.Search;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class FilterDto {
    private String key;
    private List<String> values;


}
