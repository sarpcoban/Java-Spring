package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product addProduct(Product product) {
        productRepository.save(product);
        return product;
    }
    
    public Optional<Product> updateProduct(Long id, Product updated)
    {
    	return productRepository.findById(id).map(existing -> {
    		existing.setName(updated.getName());
    		existing.setPrice(updated.getPrice());
    		return existing;
    	});
    }
    
    public boolean deleteProduct(Long id) {
    	return productRepository.deleteById(id);
    }
}