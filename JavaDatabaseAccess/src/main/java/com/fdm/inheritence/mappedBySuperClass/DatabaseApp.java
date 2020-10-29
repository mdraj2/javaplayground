package com.fdm.inheritence.mappedBySuperClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DatabaseApp {
	
	public static void main(String[] args) {
	
		Account checkingAccount = new CheckingAccount(100, 500);
		Account savingsAccount = new SavingsAccount(1000, 0);
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaDatabaseAccess");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		{
			em.persist(checkingAccount);
			em.persist(savingsAccount);
		}
		et.commit();
		em.close();
		emf.close();
		
	}

}
