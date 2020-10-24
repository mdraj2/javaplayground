package com.fdm.jdbc.simple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GameDAO {
	
	private ConnectionPool connectionPool;
	// the url is anywhere you want it to be.
	// i made them default so that i can test the methods.
	static final String CREATE_SQL = "CREATE TABLE GAMES (id INTEGER(5) PRIMARY KEY, name VARCHAR(50))";
	//private static final String INSERT_GAME_SQL ="INSERT INTO GAMES (id, name) VALUES (1, 'Animal Crossing')";
	static final String INSERT_GAME_SQL ="INSERT INTO GAMES (id, name) VALUES (?,?)";
	
	public GameDAO(ConnectionPool connectionPool) {
		super();
		this.connectionPool = connectionPool;
	}
	
	public void createTable() {
		Connection connection = connectionPool.getConnection();
		//without try with resources
		try {
			Statement statement = connection.createStatement();
			statement.execute(CREATE_SQL);
			//remember to close the statement as well.
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Remember to release that connection after we are done
		connectionPool.releaseConnection(connection);
	}
	
	public void insert(Game game) {
		Connection connection = connectionPool.getConnection();
		//try with resouces example
		try(PreparedStatement statement = connection.prepareStatement(INSERT_GAME_SQL);) {
			statement.setInt(1, game.getId());
			statement.setString(2, game.getName());
			statement.executeUpdate();
			connectionPool.releaseConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void batchInsert(List<Game> games) {
		//you want to get the prepared statement
		Connection connection = connectionPool.getConnection();
		try(PreparedStatement statement = connection.prepareStatement(INSERT_GAME_SQL);) {
			connection.setAutoCommit(false);
			//note that this for statement also works with Lists aswell as normal arrays i suppose
			for(Game game : games) {
				statement.setInt(1, game.getId());
				statement.setString(2, game.getName());
				statement.addBatch();
			}
			statement.executeBatch();
			connection.commit();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		connectionPool.releaseConnection(connection);
	}
	
	public List<Game> selectAll() {
		List<Game> arrayListGames = new ArrayList<Game>(); 
		Connection connection = connectionPool.getConnection();
		try(Statement statement = connection.createStatement();) {
			String SELECT_GAME_SQL = "SELECT * FROM GAMES";
			ResultSet rs = statement.executeQuery(SELECT_GAME_SQL);
			while(rs.next()) {
				String name = rs.getString("name");
				int id = rs.getInt("id");
				Game newGame = new Game(id,name);
				arrayListGames.add(newGame);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayListGames;
		
	}

}
