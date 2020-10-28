package com.fdm.jpa.relationships.oneToOne;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Payroll {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private float hourlyRate;
	// you need to specify attribute of the payroll in the owning side
	@OneToOne(mappedBy = "payroll")
	private Employee employee;

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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
