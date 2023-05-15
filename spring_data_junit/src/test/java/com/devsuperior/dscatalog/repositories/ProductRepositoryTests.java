package com.devsuperior.dscatalog.repositories;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import com.devsuperior.dscatalog.entities.Product;
import com.devsuperior.dscatalog.tests.Factory;

import jakarta.persistence.EntityNotFoundException;

@DataJpaTest
public class ProductRepositoryTests {
	
	@Autowired
	private ProductRepository repository;
	
	private long exintingId;
	private long notExintingId;
	private long countTotalProducts;
	
	@BeforeEach
	void setUp() throws Exception {
		exintingId = 1L;
		notExintingId = 1000L;
		countTotalProducts = 25L;
	}
		
	@Test
	public void saveShouldPersistWithAutoincrementWhenIdIsNull() {
		Product product = Factory.createProduct();
		
		product.setId(null);
		
		product = repository.save(product);
				
		Assertions.assertNotNull(product.getId());
		
		Assertions.assertEquals(product.getId(), countTotalProducts + 1);
	}
	
	@Test
	public void deleteShouldDeleteObjectWhenIdExists () {
		repository.deleteById(exintingId);
		
		Optional<Product> result = repository.findById(exintingId);
		
		Assertions.assertFalse(result.isPresent());
	}
	

	@Test
	public void deleteShouldThrowDeleteObjectWhenIdDoesNotExists () {
		repository.deleteById(notExintingId);
		
		Assertions.assertFalse(repository.existsById(notExintingId));
	}
}
