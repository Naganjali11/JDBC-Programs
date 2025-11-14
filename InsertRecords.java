package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertRecords {
static final String jdbc_url="jdbc:mysql://localhost:3306/jfs_41";
static final String userName="root";
static final String password="Naga@123";
	public static void main(String[] args) {
		try(Connection connection=DriverManager.getConnection(jdbc_url,userName,password);
				Statement statement=connection.createStatement()){
			//String inserSql="insert into employee(eno,ename,esal,eadd) values"
				//	+"(111,'malli',60000.0,'hyd')";
			
			//String updateQuery="update employee set ename='arjun', esal=75000, eadd='vjy' where eno=111";
			
			@SuppressWarnings("resource")
			Scanner scanner=new Scanner(System.in);
			
			System.out.println("enter employee records to insert");
			int numRecords=scanner.nextInt();
			for(int i=0; i<numRecords;i++) {
			System.out.println("enter details for record : "+(i+1)+" : ");
			
			System.out.print("enter employee number");
			int number=scanner.nextInt();
			scanner.nextLine();
			
			System.out.println("enter employee name");
			String name=scanner.nextLine();
			
			System.out.print("enter employee salary");
			double salary=scanner.nextDouble();
			scanner.nextLine();
			
			System.out.println("enter employee address");
			String address=scanner.nextLine();
			
			String insertQuery = "insert into employee(eno,ename,esal,eaddr)values("+number+", '"+name+"', "+salary+",'"+address+"')";
			
			int rowsAffected=statement.executeUpdate(insertQuery);
			if(rowsAffected==1) {
				System.out.println("Record inserted successfully");
			}else {
				System.out.println("Failed to insert record");
			}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
//update single record
//update multiple records
//delete single record
//delete multiple records
