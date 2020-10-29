package com.fdm.inheritence.mappedBySuperClass;

import javax.persistence.Entity;

@Entity
public class SavingsAccount extends Account {
	private double minBalance;

	public SavingsAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SavingsAccount(double balance, double minBalance) {
		super(balance);
		this.minBalance = minBalance;
		// TODO Auto-generated constructor stub
	}

	public double getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}

}
