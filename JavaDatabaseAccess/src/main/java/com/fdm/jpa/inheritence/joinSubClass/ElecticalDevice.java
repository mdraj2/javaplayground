package com.fdm.jpa.inheritence.joinSubClass;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class ElecticalDevice {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int wattage;

	public ElecticalDevice() {
		super();
	}

	public ElecticalDevice(int wattage) {
		super();
		this.wattage = wattage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWattage() {
		return wattage;
	}

	public void setWattage(int wattage) {
		this.wattage = wattage;
	}

}
