package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {
 
	static final String jdbc_url="jdbc:mysql://localhost:3306/jfs_41";
	static final String username = "root";
	static final String password = "Naga@123";
	public static void main(String[] args) {
		Connection con=null;
		try {
			//step-1: Load and Register the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
		//2.Establish Connection
			con =  DriverManager.getConnection(jdbc_url, username, password);
		//3.create statement
			 Statement st = con.createStatement();
		//4.prepare and execute sql query
			 String sqlQuery="create table if not exists employee("
					 +"eno int auto_increment primary key,"
					 +"ename varchar(100),"
					 		+ "esal decimal(10,2),"
							 +"eaddr varchar(100)"+")";
			 st.execute(sqlQuery);
			 System.out.println("Employee table created successfully");
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();

	}finally {
		if (con != null) {
			try {
				con.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	}
}
