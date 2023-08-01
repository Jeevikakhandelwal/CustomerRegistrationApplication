package com.jeev.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {

	private static Connection connection;
	static {
		// create an object of properties
		Properties properties = new Properties();

		FileInputStream fis;

		String filePath = "C:\\Users\\Jeevika\\eclipse-workspace\\CustomerRegistrationApplication\\src\\com\\jeev\\properties\\application.properties";

		try {
			fis = new FileInputStream(filePath);
			properties.load(fis);

			String url = properties.getProperty("jdbc.url");
			String userName = properties.getProperty("jdbc.userName");
			String password = properties.getProperty("jdbc.password");

			connection = DriverManager.getConnection(url, userName, password);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Establishing connection with DB
	public static Connection getDbConnection() {
		return connection;
	}

	// Close all the resources`
	public static void close(ResultSet resultSet, Statement statement, Connection connection) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
