package com.fdm.jpa.inheritence.tablePerClass;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
//the warning below does not matter because hibernate does support this
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private double maxSpeed;

	public Vehicle() {
		super();
	}
	
	public Vehicle(double maxSpeed) {
		super();
		this.maxSpeed = maxSpeed;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

}
