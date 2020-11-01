package com.fdm.jpa.inheritence.tablePerClass;

import javax.persistence.Entity;

@Entity
public class Bicycle extends Vehicle {

	private int numberOfGears;

	public Bicycle() {
		super();
	}

	public Bicycle(double maxSpeed, int numberOfGears) {
		super(maxSpeed);
		this.numberOfGears = numberOfGears;
	}

	public int getNumberOfGears() {
		return numberOfGears;
	}

	public void setNumberOfGears(int numberOfGears) {
		this.numberOfGears = numberOfGears;
	}

}
