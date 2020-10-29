package com.fdm.inheritence.singleTable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DatabaseApp {
	public static void main(String[] args) {
		
		User admin = new Admin("admin", "admin");
		User guest = new Guest("guest");
		//we can also add in a user and try to persist it
		User user = new User("user");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaDatabaseAccess");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		{
			em.persist(admin);
			em.persist(guest);
			em.persist(user);
		}
		et.commit();
		em.close();
		emf.close();
	}
}
