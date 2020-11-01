package com.fdm.jpa.inheritence.joinSubClass;

import javax.persistence.Entity;

@Entity
public class Toaster extends ElecticalDevice {

	private int maxCapacity;

	public Toaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Toaster(int wattage, int maxCapacity) {
		super(wattage);
		this.maxCapacity = maxCapacity;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

}
