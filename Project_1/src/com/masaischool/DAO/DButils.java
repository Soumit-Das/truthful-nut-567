package com.masaischool.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DButils {

	static  String url;
	static  String name;
	static  String password;
	
	static {
		try {
			
			ResourceBundle rb = ResourceBundle.getBundle("com.masaischool.DAO.credentials");
			url = rb.getString("url");
			name = rb.getString("name");
			password = rb.getString("password");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException cnf) {
			System.err.println("Class Not Found");
			System.exit(1);
		}
	}
	
	
	static Connection ConnectToDatabase()throws SQLException{
		return DriverManager.getConnection(url, name,password);
	}
	
	
	static void CloseConnection(Connection connection)throws SQLException{
		if(connection != null) {
			connection.close();
		}
	}
	public static void main(String[] args) {
		
	}
}
