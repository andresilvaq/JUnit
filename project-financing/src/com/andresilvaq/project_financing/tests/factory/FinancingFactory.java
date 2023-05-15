package com.andresilvaq.project_financing.tests.factory;

import com.andresilvaq.project_financing.entities.Financing;

public class FinancingFactory {

	public static Financing createFinancing(Double totalAmount, Double income, Integer months) {
		return new Financing(totalAmount, income, months);
	}
}
