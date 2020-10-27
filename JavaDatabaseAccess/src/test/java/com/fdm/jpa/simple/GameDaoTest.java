package com.fdm.jpa.simple;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.mockito.Mockito;

public class GameDaoTest {

	@Mock
	EntityManagerFactory mockEmf;
	@Mock
	EntityManager mockEm;
	@Mock
	EntityTransaction mockEt;

	GameDao gameDao;
	//runs before every test
	@Before
	public void initMock() {
		MockitoAnnotations.initMocks(this);
		gameDao = new GameDao(mockEmf);
		Mockito.when(mockEmf.createEntityManager()).thenReturn(mockEm);
		Mockito.when(mockEm.getTransaction()).thenReturn(mockEt);
	}

	@Test
	public void check_if_game_is_persisted_to_database() {
		//Arrange
		Game game = new Game("testgame");
		//Act 
		gameDao.persist(game);
		//Assert
		//makes sure that everything specified in order happens in the order you mentioned
		//if you do want something in order of the specifed then remove order 
		//note that the order defined in the line below does not matter, this like loading the objects.
		InOrder order = Mockito.inOrder(mockEmf,mockEm,mockEt);
		order.verify(mockEmf).createEntityManager();
		order.verify(mockEm).getTransaction();
		order.verify(mockEt).begin();
		order.verify(mockEm).persist(game);
		order.verify(mockEt).commit();
		order.verify(mockEm).close();
	}
	
	@Test
	public void that_findBy_Id_finds_a_game_by_id_in_the_database() {
		
	}

}
