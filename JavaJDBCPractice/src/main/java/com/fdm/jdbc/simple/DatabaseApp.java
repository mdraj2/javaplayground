package com.fdm.jdbc.simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.h2.Driver;

public class DatabaseApp {
	public static void main(String[] args) {
		ConnectionPool connectionPool = new ConnectionPool();
		GameDAO gameDAO = new GameDAO(connectionPool);
		List<Game> newList = gameDAO.selectAll();
	}

}
