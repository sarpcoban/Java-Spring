package com.example.demo.repository;

import com.example.demo.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public interface ProductRepository extends JpaRepository<Product, Long> {
	
	java.util.Optional<Product> findByNameIgnoreCase(String name);

	/*
    private final List<Product> database = new ArrayList<>(List.of(
        new Product(1L, "Laptop", 15000.0),
        new Product(2L, "Telefon", 8000.0),
        new Product(3L, "Klavye", 1200.0)
    ));

    public List<Product> findAll() {
        return database;
    }

    public Optional<Product> findById(Long id) {
        return database.stream()
                       .filter(p -> p.getId().equals(id))
                       .findFirst();
    }

    public void save(Product product) {
        database.add(product);
    }
    
    public boolean deleteById(Long id)
    {
    	return database.removeIf(p->p.getId().equals(id));
    }
    */
}