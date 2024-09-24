package com.springboot.ProductService.services.sortingService;

public class getSorterByCriteria {
    public static Sorter getSorterFromKey(String key){
        switch (key){
            case "priceLowToHigh":
                return new PriceLowToHighSorter();
            case "priceHighToLow":
                return new PriceHighToLowSorter();
            default:
                return null;
        }
    }
}
