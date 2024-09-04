package com.springboot.ProductService.services;

import com.springboot.ProductService.exceptions.ProductNotFoundException;
import com.springboot.ProductService.models.Category;
import com.springboot.ProductService.models.Product;
import com.springboot.ProductService.repositories.CategoryRepository;
import com.springboot.ProductService.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("dbProductService")
public class ProductServiceDBImpl implements ProductService {
    private  ProductRepository productRepository;
    private  CategoryRepository categoryRepository;

    public ProductServiceDBImpl(ProductRepository productRepository,
                                CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product createProduct(Product product) {
        Category toBePutInProduct = getCategoryToBeInProduct(product);
        product.setCategory(toBePutInProduct);
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product partialUpdateProduct(Long productId,
                                        Product product) throws ProductNotFoundException {

        Optional<Product> productToUpdateOptional = productRepository.findById(productId);
        if (productToUpdateOptional.isEmpty()) {
            throw new ProductNotFoundException();
        }
        Product productToUpdate = productToUpdateOptional.get();
        if (product.getDescription() != null) {
            productToUpdate.setDescription(product.getDescription());
        }
        if (product.getPrice() != 0) {//null
            productToUpdate.setPrice(product.getPrice());
        }
        if (product.getTitle() != null) {
            productToUpdate.setTitle(product.getTitle());
        }
        if (product.getCategory() != null) {
            Category toBePutInProduct = getCategoryToBeInProduct(product);
            productToUpdate.setCategory(toBePutInProduct);
        }
        return productRepository.save(productToUpdate);
    }

    private Category getCategoryToBeInProduct(Product product) {
        String categoryName = product.getCategory().getName();

        Optional<Category> category =
                categoryRepository.findByName(categoryName);
        Category toBePutInProduct = null;

        if (category.isEmpty()) {
            Category toSaveCategory = new Category();
            toSaveCategory.setName(categoryName);

            toBePutInProduct = toSaveCategory;
        } else {
            toBePutInProduct = category.get();
        }
        return toBePutInProduct;
    }
    @Override
    public Product getProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            return null;
        }
        return product.get();
    }
    @Override
    public Product putProduct(Long id,Product product) throws ProductNotFoundException {
        Optional<Product> productToUpdateOptional = productRepository.findById(id);
        if (productToUpdateOptional.isEmpty()) {
            throw new ProductNotFoundException();
        }
        Product productToUpdate = productToUpdateOptional.get();
        productToUpdate.setDescription(product.getDescription());
        productToUpdate.setPrice(product.getPrice());
        productToUpdate.setTitle(product.getTitle());
        Category toBePutInProduct = getCategoryToBeInProduct(product);
        productToUpdate.setCategory(toBePutInProduct);
        return productRepository.save(productToUpdate);
    }
    @Override
    public boolean deleteProduct(Long id) throws ProductNotFoundException {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new ProductNotFoundException();
        }
        productRepository.delete(product.get());
        return true;
    }

}
