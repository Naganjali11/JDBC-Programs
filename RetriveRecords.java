package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class RetriveRecords {
	static final String jdbc_url="jdbc:mysql://localhost:3306/jfs_41";
	static final String userName="root";
	static final String password="Naga@123";
	public static void main(String[] args) {
		try(Connection connection=DriverManager.getConnection(jdbc_url,userName,password);
				Statement statement=connection.createStatement()){
			Scanner scanner=new Scanner(System.in);
			//System.out.println("Enter Employee Number to Retrive record");
			//int number=scanner.nextInt();
			//String selectQuery="select*from employee where eno="+number+"";
			String selectQuery="select*from Employee where esal>50000";
			ResultSet rs=statement.executeQuery(selectQuery);
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"=="+rs.getString(2)+"---"+
						rs.getDouble(3)+"===="+rs.getString(4));	
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
