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
		Game game = new Game(2, "Mario Cart");
		Game managedGame = gameDao.merge(game);
		System.out.println(managedGame.getName());
		emf.close();
		
	}

}
