package com.devsuperior.dscatalog.tests;

import java.time.Instant;

import com.devsuperior.dscatalog.dto.ProductDTO;
import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.entities.Product;

public class Factory {

	public static Product createProduct() {
		Product prod = new Product(1L, "Phone", "Good Phone", 800.00, "", Instant.parse("2020-10-20T03:00:00Z"));
		prod.getCategories().add(new Category(1L, "Electronics"));
		return prod;
	}
	
	public static ProductDTO createProductDTO() {
		Product prod = Factory.createProduct();
		return new ProductDTO(prod, prod.getCategories());
	}
}
