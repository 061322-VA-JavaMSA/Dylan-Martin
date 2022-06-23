package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Driver {
	
	public static void main(String[] args) {
		String url = "jdbc:postgresql://database-1.c06saqkwyoup.us-east-1.rds.amazonaws.com:5432/postgres";
		String username = "postgres";
		String password = "Glaive982#";
		
		try {
			Connection c = DriverManager.getConnection(url, username, password);
			System.out.println(c.getMetaData().getDriverName());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
