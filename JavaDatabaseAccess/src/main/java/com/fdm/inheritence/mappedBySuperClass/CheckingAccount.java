package com.fdm.inheritence.mappedBySuperClass;

import javax.persistence.Entity;

@Entity
public class CheckingAccount extends Account {
	private double loanAmount;

	public CheckingAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CheckingAccount(double balance, double loanAmount) {
		super(balance);
		this.loanAmount = loanAmount;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

}
