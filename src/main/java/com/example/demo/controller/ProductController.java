package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.getProductById(id)
                             .orElseThrow(() -> new RuntimeException("Ürün bulunamadı: " + id));
    }

    @PostMapping
    public String addProduct(@RequestParam Long id,
                             @RequestParam String name,
                             @RequestParam double price) {
        return productService.addProduct(id, name, price);
    }
}