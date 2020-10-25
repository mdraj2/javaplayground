package com.fdm.jpa.simple;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GameDao {
	//create a new game
	//you need an entityTransaction manager
	
	private EntityManagerFactory emf;
	
	public GameDao(EntityManagerFactory emf) {
		super();
		this.emf = emf;
	}
	
	public void persist(Game game) {
		EntityManager em = emf.createEntityManager();
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
		//unlike before we want to keep the emf open because gameDao will use that emf
		//emf.close();
	}
	
	public Game findById(int id) {
		
		//get the entityManager
		EntityManager em = emf.createEntityManager();
		Game game = em.find(Game.class, id);
		em.close();
		return game;
	}
	
}
