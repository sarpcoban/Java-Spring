package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Component
public class DataLoader implements CommandLineRunner {
	
	private final ProductRepository productRepository;
	
	public DataLoader(ProductRepository productRepository)
	{
		this.productRepository = productRepository;
	}
	
	@Override
	public void run(String... args) {
		productRepository.save(new Product("Laptop", 15000.0));
		productRepository.save(new Product("Telefon", 8000.0));
		productRepository.save(new Product("Klavye", 1200.0));
	}

}
