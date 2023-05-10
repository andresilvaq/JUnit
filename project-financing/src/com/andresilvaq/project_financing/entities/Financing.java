package com.andresilvaq.project_financing.entities;

public class Financing {
	private Double totalAmount;
	private Double income;
	private Integer months;
	
	public Financing(Double totalAmount, Double income, Integer months) {

		validateValues(totalAmount, income, months);
		
		this.totalAmount = totalAmount;
		this.income = income;
		this.months = months;
	}
	
	private void validateValues(Double totalAmount, Double income, Integer months) {
		Double total = totalAmount - totalAmount * 0.2;
		Double valueInstallment = total / months;
		
		// Erro se valor da prestação for superior a metade do salário
		if(valueInstallment > (income / 2)) {
			throw new IllegalArgumentException("Valor da parcela maior que metade do salário.");
		}
		
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public Integer getMonths() {
		return months;
	}

	public void setMonths(Integer months) {
		this.months = months;
	}
	
	public static void main(String [] args) {
		Financing f1 = 
				new Financing(100000d, 2000d, 20);
	}
} 
 