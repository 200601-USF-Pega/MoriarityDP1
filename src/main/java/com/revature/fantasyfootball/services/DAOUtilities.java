package com.revature.fantasyfootball.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOUtilities {

	private static Connection connection;
	
	public static synchronized Connection getConnection() throws SQLException {
		if (connection == null || connection.isClosed()) {
			try {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(MyProps.url, MyProps.username, MyProps.password);
			} catch (ClassNotFoundException e) {
				System.out.println("Could not get connection!");
				System.out.println(e.getMessage());
			}
			
		}
		return connection;
	}
}
