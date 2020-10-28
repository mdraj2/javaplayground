package com.fdm.jpa.relationships.oneToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DatabaseApp {

	public static void main(String[] args) {
		Payroll payroll = new Payroll(25.00F);
		Employee employeeOne = new Employee("John",payroll);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaDatabaseAccess");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		{
			em.persist(employeeOne);
		}
		et.commit();
		em.close();
		emf.close();
		

	}

}
