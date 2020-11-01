package com.fdm.jpa.inheritence.tablePerClass;

import javax.persistence.Entity;

@Entity
public class Car extends Vehicle{
	
	private int horsePower;

	public Car() {
		super();
	}

	public Car(double maxSpeed, int horsePower) {
		super(maxSpeed);
		this.horsePower = horsePower;
	}

	public int getHorsePower() {
		return horsePower;
	}

	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}
	
	
	

}
