package com.springboot.ProductService.services.fliteringService;

public class FilterFactory {
    public static Filter getFilterFromKey(String key){
        switch (key){
            case "brand":
                return new BrandFilter();
            case "ram":
                return new RAMFilter();
            default:
                return null;
        }
    }
}
