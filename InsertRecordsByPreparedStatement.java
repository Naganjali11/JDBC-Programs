package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertRecordsByPreparedStatement {
	static final String jdbc_url="jdbc:mysql://localhost:3306/jfs_41";
	static final String userName="root";
	static final String password="Naga@123";
	public static void main(String[] args) {
		String insertQuery="insert into employee(eno,ename,esal,eaddr)values"+"(?,?,?,?)";
		try(Connection connection=DriverManager.getConnection(jdbc_url,userName,password);
				PreparedStatement pst=connection.prepareStatement(insertQuery);
				Scanner scanner=new Scanner(System.in)){
			System.out.println("Enter Number:");
			int number=scanner.nextInt();
			System.out.println("Enter Name:");
			String name=scanner.next();
			System.out.println("Enter Salary:");
			double salary=scanner.nextDouble();
			System.out.println("Enter Location:");
			String location=scanner.next();
			//set values to a positional parameters
			pst.setInt(1,number);
			pst.setString(2,name);
			pst.setDouble(3,salary);
			pst.setString(4,location);
			
			int rowsAffected=pst.executeUpdate();
			System.out.println(rowsAffected+"rows inserted sucessfully");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		}
	}
//insert multiple records values from end user
//update single record and multiple records values from end user
//select single record from value end user
//delete single record multiple records values from end user
//retrive all records by prepared statement


