package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "products")
public class Product {
	//@JsonProperty("id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	//@JsonProperty("name")
	//@NotNull(message = "İsim boş olamaz.")
	//@NotBlank(message = "İsim sadece boşluk olamaz.")
    private String name;
	//@JsonProperty("price")
	//@NotNull(message = "Fiyat boş olamaz.")
	//@Positive(message = "Fiyat sıfıdan büyük olmalıdır.")
    private double price;

	public Product() {}
	
    public Product(String name, double price) {
        //this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getter / Setter
    public Long getId()       { return id; }
    public String getName()   { return name; }
    public double getPrice()  { return price; }
    
    public void setId(Long id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setPrice(double price) {this.price = price;}
}