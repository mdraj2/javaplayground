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
	
	public void deleteById(int id) {
		//you need an entity manager
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		//get a managed game. note you do not need et for this
		Game foundGame = em.find(Game.class, id);
		et.begin();
		{	//note that this method needs to be a managed game
			em.remove(foundGame);
		}
		et.commit();
		em.close();
	}
	
	public void update(Game game) {
		EntityManager em = emf.createEntityManager();
		Game foundGame = em.find(Game.class, game.getId());
		EntityTransaction et = em.getTransaction();
		et.begin();
		{
			foundGame.setName(game.getName());			
		}
		et.commit();
		em.close();
	}
	
	public Game merge(Game pojoGame) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Game managedGame;
		et.begin();
		{
			managedGame = em.merge(pojoGame);
		}
		et.commit();
		em.close();
		return managedGame;
	}
}
