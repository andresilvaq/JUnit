package com.andresilvaq.project_junit.tests.factory;

import com.andresilvaq.project_junit.entities.Account;

public class AccountFactory {

	public static Account createEmptyAccount() {
		return new Account(1L, 0.0);
	}
	
	public static Account createAccount(double initialBalance) {
		return new Account(1L, initialBalance);
	}
	
}
