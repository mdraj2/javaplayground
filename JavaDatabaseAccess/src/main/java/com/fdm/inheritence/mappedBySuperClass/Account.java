package com.fdm.inheritence.mappedBySuperClass;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Account {

	// note that you need to give the id because any class that inherits from the
	// superclass
	// will get that id aswell
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double balance;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(double balance) {
		super();
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
