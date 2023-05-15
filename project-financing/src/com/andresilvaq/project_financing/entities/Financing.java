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
	
	public Double entry () {
		return this.totalAmount * 0.2;
	}
	
	public Double quota() {
		Double total = this.totalAmount - entry();

		return total / this.months;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public Double getIncome() {
		return income;
	}

	public Integer getMonths() {
		return months;
	}

	public void setTotalAmount(Double totalAmount) {
		validateValues(totalAmount, this.income, this.months);
		this.totalAmount = totalAmount;
	}

	public void setIncome(Double income) {
		validateValues(this.totalAmount, income, this.months);
		this.income = income;
	}

	public void setMonths(Integer months) {
		validateValues(this.totalAmount, this.income, months);
		this.months = months;
	}

} 
 