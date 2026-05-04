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
    
    public Optional<Product> getProductByName(String name)
    {
    	return productRepository.findByNameIgnoreCase(name);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
    
    public Optional<Product> updateProduct(Long id, Product updated)
    {
    	return productRepository.findById(id).map(existing -> {
    		existing.setName(updated.getName());
    		existing.setPrice(updated.getPrice());
    		return productRepository.save(existing);
    	});
    }
    
    public boolean deleteProduct(Long id) {
    	if (!productRepository.existsById(id)) return false;
    	productRepository.deleteById(id);
    	return true;
    }
}