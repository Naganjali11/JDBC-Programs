package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchWithPreparedStatement {
	 static final String jdbc_url = "jdbc:mysql://localhost:3306/jfs_41";
	  static final String userName = "root";
	  static final String password = "Naga@123";
	public static void main(String[] args) {
		
		try(Connection connection=DriverManager.getConnection(jdbc_url,userName,password)){
			String insertQuery="insert into employee(eno,ename,esal,eaddr)values"+"(?,?,?,?)";
			PreparedStatement pst1=connection.prepareStatement(insertQuery);
			pst1.setInt(1,555);
			pst1.setString(2, "Pavithra");
			pst1.setDouble(3,29999);
			pst1.setString(4, "Kavali");
			pst1.addBatch();
			String updateQuery="Update employee set esal=esal+?where esal<?";
			PreparedStatement pst2=connection.prepareStatement(updateQuery);
			pst2.setDouble(1, 10000);
			pst2.setDouble(2, 40000);
			pst2.addBatch();
			
			int[] insertResults=pst1.executeBatch();
			int[] updateResults=pst2.executeBatch();
			
			int total=0;
			for(int count:insertResults) {
				total+=count;
			}
			for(int count:updateResults) {
				total+=count;
			}
			System.out.println("Total Rows Affected:"+total);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
			 
	}

}
