package com.example.demo.controller;

import com.example.demo.dto.ProductRequestDTO;
import com.example.demo.dto.ProductResponseDTO;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductResponseDTO> getAll() {
        return productService.getAllProducts();
    }

    /*
    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id)
    {
    	return productService.getProductById(id)
    			.map(ResponseEntity::ok)
    			.orElse(ResponseEntity.notFound().build());
    }
    */
    
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getById(@PathVariable Long id)
    {
    	return ResponseEntity.ok(productService.getProductById(id));
    }
    
    /*
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.getProductById(id)
                             .orElseThrow(() -> new RuntimeException("Ürün bulunamadı: " + id));
    }
    */

    
    /*
    @GetMapping("/search")
    public ResponseEntity<Product> getByName(@RequestParam String name)
    {
    	return productService.getAllProducts().stream()
    			.filter(p->p.getName().equalsIgnoreCase(name))
    			.findFirst()
    			.map(ResponseEntity::ok)
    			.orElse(ResponseEntity.notFound().build());
    }
    */
    
    @GetMapping("/search")
    public ResponseEntity<Product> getByName(@RequestParam String name)
    {
    	return productService.getProductByName(name)
    			.map(ResponseEntity::ok)
    			.orElse(ResponseEntity.notFound().build());
    }
    
    /*
    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product)
    {
    	Product saved = productService.addProduct(product);
    	return ResponseEntity.status(201).body(saved);
    }*/
    
    @PostMapping
    public ResponseEntity<ProductResponseDTO> create(@Valid @RequestBody ProductRequestDTO dto)
    {
    	return ResponseEntity.status(201).body(productService.addProduct(dto));
    }
    
    /*
    @PostMapping
    public String addProduct(@RequestParam Long id,
                             @RequestParam String name,
                             @RequestParam double price) {
        return productService.addProduct(id, name, price);
    }
    */
    
    /*
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product updated)
    {
    	return productService.updateProduct(id, updated)
    			.map(ResponseEntity::ok)
    			.orElse(ResponseEntity.notFound().build());
    }
    */
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> update(@PathVariable Long id,
    		@Valid @RequestBody ProductRequestDTO dto)
    {
    	return ResponseEntity.ok(productService.updateProduct(id,  dto));
    }
    
    /*
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id)
    {
    	return productService.deleteProduct(id)
    		? ResponseEntity.noContent().build()
    		: ResponseEntity.notFound().build();
    }
    */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id)
    {
    	productService.deleteProduct(id);
    	return ResponseEntity.noContent().build();
    }
}