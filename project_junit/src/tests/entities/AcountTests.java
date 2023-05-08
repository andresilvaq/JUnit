package tests.entities;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import project_junit.Account;

public class AcountTests {
	 
	@Test
	/**
	 * Deposito incrementa o saldo quando o valor é positivo
	 */
	public void depositShouldIncreaseBalanceWhenPositiveAmount () {
		double amount = 200.0;
		double expectedValue = 196.0;
		 
		Account acc = new Account(1L, 0.0);
		
		acc.deposit(amount);
		
		Assertions.assertEquals(expectedValue, acc.getBalance());
	}
	
	@Test
	/**
	 * Deposito não faz nada quando informar valor negativo
	 */
	public void depositShouldDoNothingWhenNegativeAmount() {
		double amount = -200.0;
		double expectedValue = 0;
		 
		Account acc = new Account(1L, 0.0);
		
		acc.deposit(amount);
		
		Assertions.assertEquals(acc.getBalance(), expectedValue); 
	}
}