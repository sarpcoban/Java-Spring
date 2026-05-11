package com.example.demo.service;

import com.example.demo.exception.ProductNotFoundException;
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

    public Product getProductById(Long id)
    {
    	return productRepository.findById(id)
        		.orElseThrow(()-> new ProductNotFoundException(id));
    }
    
    /*
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }
    */
    public Optional<Product> getProductByName(String name)
    {
    	return productRepository.findByNameIgnoreCase(name);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
    
    public Product updateProduct(Long id, Product updated)
    {
    	Product existing = productRepository.findById(id)
    			.orElseThrow(()->new ProductNotFoundException(id));
    	existing.setName(updated.getName());
    	existing.setPrice(updated.getPrice());
    	return productRepository.save(existing);
    }
    
    /*
    public Optional<Product> updateProduct(Long id, Product updated)
    {
    	return productRepository.findById(id).map(existing -> {
    		existing.setName(updated.getName());
    		existing.setPrice(updated.getPrice());
    		return productRepository.save(existing);
    	});
    }
    */
    
    public void deleteProduct(Long id)
    {
    	if(!productRepository.existsById(id))
    	{
    		throw new ProductNotFoundException(id);
    	}
    	productRepository.deleteById(id);
    }
    
    /*
    public boolean deleteProduct(Long id) {
    	if (!productRepository.existsById(id)) return false;
    	productRepository.deleteById(id);
    	return true;
    }
    */
}