package com.fdm.jpa.relationships.oneToOne;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payroll {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private float hourlyRate;

	public Payroll() {
		super();
	}

	public Payroll(float hourlyRate) {
		super();
		this.hourlyRate = hourlyRate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(float hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

}
