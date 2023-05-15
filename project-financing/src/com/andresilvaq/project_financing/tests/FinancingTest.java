package com.andresilvaq.project_financing.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.andresilvaq.project_financing.entities.Financing;
import com.andresilvaq.project_financing.tests.factory.FinancingFactory;

public class FinancingTest {

	@Test
	/**
	 * Deve criar o objeto co os dados corretos, se válidos
	 */
	public void construtorComDadosValidos() {

		Double totalAmount = 100000.00;
		Double income = 2000.00;
		Integer months = 80;

		Financing instancia = new Financing(totalAmount, income, months);
		
		Assertions.assertNotNull(instancia);
	}

	@Test
	/**
	 * 
	 */
	public void construtorComDadosInvalidos() {
		Double totalAmount = 100000.00;
		Double income = 2000.00;
		Integer months = 40;
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing instancia = new Financing(totalAmount, income, months);
		});
	}


	
	@Test
	/**
	 * 
	 */
	public void setTotalFinanciadoDadosValidos() {
		double amount = 12000.0;
		double expectedValue = 120000.0;
				
		Double totalAmount = 10000.00;
		Double income = 3000.00;
		Integer months = 80;
		
		Financing instancia = FinancingFactory.createFinancing(totalAmount, income, months);
		instancia.setTotalAmount(amount);
		
		Assertions.assertEquals(instancia.getTotalAmount(), expectedValue);
	}
	
	@Test
	/**
	 * 
	 */
	public void setTotalFinanciadoDadosInvalidos() {
		double amount = 400000.0;
				
		Double totalAmount = 100000.00;
		Double income = 2000.00;
		Integer months = 80;
		
		Financing instancia = FinancingFactory.createFinancing(totalAmount, income, months);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			instancia.setTotalAmount(amount);
		});
	}

	
	@Test
	/**
	 * 
	 */
	public void setRendaMensalDadosValidos() {
		double newIncome = 3000.0;
		double expectedValue = 3000.0;
				
		Double totalAmount = 10000.00;
		Double income = 2000.00;
		Integer months = 80;
		
		Financing instancia = FinancingFactory.createFinancing(totalAmount, income, months);
		instancia.setIncome(newIncome);
		
		Assertions.assertEquals(instancia.getIncome(), expectedValue);
	}
	
	@Test
	/**
	 * 
	 */
	public void setRendaMensalDadosInvalidos() {
		double newIncome = 3000.0;
		double expectedValue = 3000.0;
				
		Double totalAmount = 10000.00;
		Double income = 2000.00;
		Integer months = 80;
		
		Financing instancia = FinancingFactory.createFinancing(totalAmount, income, months);
		
		
		Assertions.assertEquals(instancia.getIncome(), expectedValue);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			instancia.setIncome(newIncome);
		});
	}

	@Test
	/**
	 * 
	 */
	public void setQtdeMesesDadosValidos() {
		int newMonths = 100;
		int expectedValue = 100;
				
		Double totalAmount = 10000.00;
		Double income = 2000.00;
		Integer months = 80;
		
		Financing instancia = FinancingFactory.createFinancing(totalAmount, income, months);
		instancia.setMonths(100);
		
		Assertions.assertEquals(instancia.getMonths(), expectedValue);
	}
	
	@Test
	/**
	 * 
	 */
	public void setQtdeMesesDadosInvalidos() {
		int newMonths = 100;
		int expectedValue = 40;
				
		Double totalAmount = 10000.00;
		Double income = 2000.00;
		Integer months = 80;
		
		Financing instancia = FinancingFactory.createFinancing(totalAmount, income, months);
		
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			instancia.setMonths(100);
		});
	}

	@Test
	/**
	 * 
	 */
	public void retornaValorEntrada() {
		Double totalAmount = 10000.00;
		Double income = 2000.00;
		Integer months = 80;		
		
		int expectedValue = (int)(totalAmount * 0.2);
		
		Financing instancia = FinancingFactory.createFinancing(totalAmount, income, months);
		
		Assertions.assertEquals(instancia.entry(), expectedValue);
	}
	
	@Test
	/**
	 * 
	 */
	public void retornaValorParcela() {
		Double totalAmount = 10000.00;
		Double income = 2000.00;
		Integer months = 80;
		
		Double total = totalAmount - (totalAmount * 0.2);
		Double expectedValue = total / months;
		
		Financing instancia = FinancingFactory.createFinancing(totalAmount, income, months);
		
		Assertions.assertEquals(instancia.quota(), expectedValue);
	}
//	
//	@Test
//	/**
//	 * 
//	 */
//	public void () {
//		
//	}

	public static void main(String[] args) {
		Financing f1 = new Financing(100000d, 2000d, 20);

		Financing f2 = new Financing(100000d, 2000d, 80);

	}

}
