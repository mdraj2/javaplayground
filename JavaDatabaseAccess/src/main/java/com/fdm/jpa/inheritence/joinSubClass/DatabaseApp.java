package com.fdm.jpa.inheritence.joinSubClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.fdm.jpa.inheritence.tablePerClass.Bicycle;
import com.fdm.jpa.inheritence.tablePerClass.Car;
import com.fdm.jpa.inheritence.tablePerClass.Vehicle;

public class DatabaseApp {

	public static void main(String[] args) {
		ElecticalDevice toaster = new Toaster(150,4);
		ElecticalDevice tv = new Television(250, 100);
		ElecticalDevice dummy = new ElecticalDevice(500);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaDatabaseAccess");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		{
			em.persist(toaster);
			em.persist(tv);
			em.persist(dummy);

		}
		et.commit();
		em.close();
		emf.close();
	}

}
