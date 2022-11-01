package com.employee.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlUtility {

	public static Connection getConnectionToMySQL() {
		Connection connection = null;
		try {
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/ford_schema?" + "user=ford&password=ford");
			System.out.println("Connection to MYSQL successful!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;
	}
}
