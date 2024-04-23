package com.sel.prac;

//import java.sql.Connection
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class DatabaseTesting {

	String getCredentials = "select username, password from credentials where website_name='IRCTC';";

	@BeforeMethod
	public Connection connectToDataBase() {

		String host = "localhost";
		int port = 3306;
		String dbName = "user_authentication_db";

		Connection connection = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + dbName, "root",
					"Bib@swan91");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;

	}

	@Test
	public void testDatabase() throws SQLException {

		Connection conn = connectToDataBase();
		Statement s = conn.createStatement();

		ResultSet result = s.executeQuery(getCredentials);

		while (result.next()) {

			if (result.getString("username").equalsIgnoreCase("bibaswaba")) {
				System.out.println("UserName: " + result.getString("username"));
				System.out.println("Password: " + result.getString("password"));
				break;
			}
		}

	}

	@AfterMethod
	public void closeDBConnection() {
		try {
			connectToDataBase().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("[INFO] DB Connection Closed");

	}

}
