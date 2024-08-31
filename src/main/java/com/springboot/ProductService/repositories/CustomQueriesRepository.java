package com.springboot.ProductService.repositories;

public class CustomQueriesRepository {
    String GET_PRODUCTS_WITH_SUBCATEGORY_NAME =
            "select * from product p join category c on p.category_id = c.id join subcategory s where s.category_id = c.id";
}
