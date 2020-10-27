package com.fdm.jpa.simple;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DatabaseApp {
	
	public static void main(String[] args) {
		//this refers to the name of the persistence-unit in our persistence xml
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaDatabaseAccess");
		GameDao gameDao = new GameDao(emf);
		Game game = new Game(1, "Mario Cart");
		gameDao.persist(game);
		Game game2 = new Game(2, "Mario Cart2");
		gameDao.persist(game2);
		System.out.println("foundGame = " + gameDao.findByTitle("Mario Cart2"));
		
		emf.close();
		
	}

}
