package com.andresilvaq.project_junit.tests.entities;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import com.andresilvaq.project_junit.entities.Account;
import com.andresilvaq.project_junit.tests.factory.AccountFactory;

public class AcountTests {

	@Test
	/**
	 * Deposito incrementa o saldo quando o valor é positivo
	 */
	public void depositShouldIncreaseBalanceWhenPositiveAmount() {
		double amount = 200.0;
		double expectedValue = 196.0;

		Account acc = AccountFactory.createEmptyAccount();

		acc.deposit(amount);

		Assertions.assertEquals(expectedValue, acc.getBalance());
	}

	@Test
	/**
	 * Deposito não faz nada quando informar valor negativo
	 */
	public void depositShouldDoNothingWhenNegativeAmount() {
		double amount = -200.0;
		double expectedValue = 100;

		Account acc = AccountFactory.createAccount(expectedValue);

		acc.deposit(amount);

		Assertions.assertEquals(expectedValue, acc.getBalance());
	}

	@Test
	/**
	 * Valor final 0.0 quando ocorre Retirada Total
	 */
	public void fullWithdrawShouldClearBalance() {
		double expectedValue = 0;
		double initialBalance = 800.00;

		Account acc = AccountFactory.createAccount(initialBalance);

		double result = acc.fullWithdraw();

		Assertions.assertTrue(expectedValue == acc.getBalance());
		Assertions.assertTrue(result == initialBalance);
	}

	@Test
	/**
	 * Se o saldo estível disponível deverá diminuir o saldo numa retirada
	 */
	public void withdrawShouldDecreaseBalanceWhenSufficientBalance() {
		double expectedValue = 300.00;

		Account acc = AccountFactory.createAccount(800.00);

		acc.withdraw(500.00);

		Assertions.assertEquals(expectedValue, acc.getBalance());

	}

	@Test
	/**
	 * 
	 */
	public void withdrawShouldThrowExceptionWhenInsufficientBalance() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Account acc = AccountFactory.createAccount(800.00);

			acc.withdraw(801.00);
		});

	}
}