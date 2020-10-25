package com.fdm.jpa.simple;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DatabaseApp {
	
	public static void main(String[] args) {
		//this refers to the name of the persistence-unit in our persistence xml
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaDatabaseAccess");
		GameDao gameDao = new GameDao(emf);
		Game game = new Game(1, "Animal Crossing");
		gameDao.persist(game);
		//this is a managed game
		Game foundGame = gameDao.findById(1);
		//we will close the emf here
		emf.close();
		
	}

}
