package com.fdm.jdbc.simple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Mockito;

public class GameDaoTest {
//testing the insert method
	//anything that we will mock will have a mock annotation above it
	@Mock
	ConnectionPool mockConnectionPool;
	@Mock
	Connection mockConnection;
	@Mock
	PreparedStatement mockPreparedStatement;
	
	GameDAO gameDao;
	//this is to initialize our mocks
	@Before
	public void initializeMocks() {
		//this will basically initialize all the mocks on this class
		MockitoAnnotations.initMocks(this);
		//because none of the mock objects will be created until this method runs we will intantiate inside here
		gameDao = new GameDAO(mockConnectionPool);
	}
	
	@Test
	public void that_insert_inserts_a_game_into_the_database() throws SQLException {
		//now we need the mocked objects
		//Arrange 
		Game game = new Game(1,"Animal Crossing");
		Mockito.when(mockConnectionPool.getConnection()).thenReturn(mockConnection);
		Mockito.when(mockConnection.prepareStatement(GameDAO.INSERT_GAME_SQL)).thenReturn(mockPreparedStatement);
		//Act
		gameDao.insert(game);
		//Assert
		Mockito.verify(mockConnectionPool).getConnection();
		Mockito.verify(mockConnection).prepareStatement(GameDAO.INSERT_GAME_SQL);
		Mockito.verify(mockPreparedStatement).setInt(1, game.getId());
		Mockito.verify(mockPreparedStatement).setString(2, game.getName());
		Mockito.verify(mockPreparedStatement).executeUpdate();
		//this is done by try with resources block
		Mockito.verify(mockPreparedStatement).close();
		Mockito.verify(mockConnectionPool).releaseConnection(mockConnection);
	}
	
}
