package com.springboot.ProductService.controllers;

import com.springboot.ProductService.dtos.Product.GetProductDto;
import com.springboot.ProductService.dtos.Search.FilterDto;
import com.springboot.ProductService.dtos.Search.SearchResponseDto;
import com.springboot.ProductService.dtos.Search.SortingCriteria;
import com.springboot.ProductService.models.Product;
import com.springboot.ProductService.services.SearchService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/search")
public class SearchController {
    private SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }
    @GetMapping("/")
    public SearchResponseDto search(@RequestParam("query") String query,
                                    @RequestParam("filters")List<FilterDto> filters,
                                    @RequestParam("sortBy") SortingCriteria sortingCriteria,
                                    @RequestParam("pageNumber") int pageNumber,
                                    @RequestParam("pageSize") int pageSize) {
        SearchResponseDto response = new SearchResponseDto();
        Page<Product> productsPage =  searchService.search(
                query, filters, sortingCriteria, pageNumber, pageSize);

        List<GetProductDto> getProductDtos = productsPage.getContent().stream()
                .map(GetProductDto::from)
                .collect(Collectors.toList());

        Pageable pageable = PageRequest.of(productsPage.getNumber(), productsPage.getSize(), productsPage.getSort());
        Page<GetProductDto> getProductDtoPage = new PageImpl<>(getProductDtos, pageable, productsPage.getTotalElements());

        response.setProductsPage(getProductDtoPage);

        return response;
    }

}
