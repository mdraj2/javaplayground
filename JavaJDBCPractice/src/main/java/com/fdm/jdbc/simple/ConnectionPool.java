package com.fdm.jdbc.simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.h2.Driver;

public class ConnectionPool {
	private static final String url = "jdbc:h2:file:C:\\Users\\malit\\data\\mydb";
	private static final String user = "admin";
	private static final String password = "admin";
	
	public Connection getConnection() {
		Connection newconnection = null;
		try {
			DriverManager.registerDriver(new Driver());
			newconnection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newconnection;
	}
	
	public void releaseConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
