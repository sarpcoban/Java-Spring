package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class ProductRequestDTO {
	
	@NotBlank(message = "İsim boş olamaz")
	private String name;
	
	@Positive(message = "Fiyat sıfırdan büyük olmalı.")
	private double price;
	
	public ProductRequestDTO()
	{
		
	}
	
	public String getName() {return name; }
	public double getPrice() {return price; }
	
	public void setName(String name) {this.name = name;}
	public void setPrice(double price) {this.price = price;}

}
