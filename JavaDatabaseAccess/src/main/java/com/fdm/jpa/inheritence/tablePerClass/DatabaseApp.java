package com.fdm.jpa.inheritence.tablePerClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DatabaseApp {

	public static void main(String[] args) {
		
		Vehicle car = new Car(220,300);
		Vehicle bike = new Bicycle(50,18);
		Vehicle plane = new Vehicle(1000);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaDatabaseAccess");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		{
			em.persist(car);
			em.persist(bike);
			em.persist(plane);
			
		}
		et.commit();
		em.close();
		emf.close();
	}
}
