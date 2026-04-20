package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
	@JsonProperty("id")
    private Long id;
	@JsonProperty("name")
    private String name;
	@JsonProperty("price")
    private double price;

	public Product() {}
	
    public Product(Long id, String name, double price) {
        this.id = id;
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