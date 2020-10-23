package com.malith.playground.corejava.chapter4;

public class EmployeeTest {
	public static void main(String[] args) {
		//fill the staff array with three Employee objects
		//this is an immutable array containing 1 employee objects
		Employee[] staff = new Employee[1];
		
		staff[0] = new Employee("car", 75000, 1987, 12, 15);
		
		for(Employee staf : staff) {
			staf.raiseSalary(5);
		}
		
		for(Employee e: staff) {
			System.out.println("name =" + e.getName() + ",salary=" + e.getSalary());
		}
	}
}
