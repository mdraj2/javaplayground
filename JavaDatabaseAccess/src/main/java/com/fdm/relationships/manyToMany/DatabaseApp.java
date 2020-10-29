package com.fdm.relationships.manyToMany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DatabaseApp {
	public static void main(String[] args) {
		
		Store woolWorths = new Store("Woolworths");
		Store coles = new Store("Coles");
		
		Product pepsi = new Product("Pepsi", 2.50);
		Product water = new Product("Water", 1.00);
		Product coke = new Product("Coke", 2.49);
		
		woolWorths.add(coke);
		coke.addToStore(woolWorths);
		woolWorths.add(water);
		water.addToStore(woolWorths);
		coles.add(water);
		water.addToStore(coles);
		coles.add(pepsi);
		pepsi.addToStore(coles);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaDatabaseAccess");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		{
			em.persist(woolWorths);
			em.persist(coles);
		}
		et.commit();
		em.close();
		emf.close();
	}
}
