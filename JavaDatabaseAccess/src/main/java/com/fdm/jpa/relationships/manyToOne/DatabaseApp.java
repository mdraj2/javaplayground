package com.fdm.jpa.relationships.manyToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DatabaseApp {

	public static void main(String[] args) {
		
		//when you make it to bidirectional you need to add the trainees to the list of the streams
		Stream devStream = new Stream("Dev");
		Stream opsStream = new Stream("Ops");
		Trainee traineeOne = new Trainee("Tom",devStream);
		devStream.add(traineeOne);
		Trainee traineeTwo = new Trainee("Malith",opsStream);
		opsStream.add(traineeTwo);
		Trainee traineeThree = new Trainee("Adam",devStream);
		devStream.add(traineeThree);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaDatabaseAccess");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		{
			//note that the order does not matter because it will happen in one transaction
			em.persist(devStream);
			em.persist(opsStream);
			em.persist(traineeOne);
			em.persist(traineeTwo);
			em.persist(traineeThree);
			
		}
		et.commit();
		em.close();
		emf.close();

	}

}
