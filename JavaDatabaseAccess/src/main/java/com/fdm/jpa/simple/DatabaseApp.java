package com.fdm.jpa.simple;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DatabaseApp {
	
	public static void main(String[] args) {
		//this refers to the name of the persistence-unit in our persistence xml
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaDatabaseAccess");
		EntityManager em = emf.createEntityManager();
		
		
		Game game = new Game(1, "Animal Crossing");
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		//these brackets are not complusory
		{
			//we will use persist method which is basically a create implementation
			em.persist(game);
		}
		//this line will commit everything
		et.commit();
		//does not matter because it is single thread but still good practice
		em.close();
		emf.close();
	}

}
