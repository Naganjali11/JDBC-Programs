package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetDemo {
	static final String jdbc_url="jdbc:mysql://localhost:3306/jfs_41";
	static final String userName="root";
	static final String password="Naga@123";
	public static void main(String[] args) {
		String sqlQuery="select*from Employee";
		try(Connection connection=DriverManager.getConnection(jdbc_url,userName,password);
				Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);ResultSet rs=statement.executeQuery(sqlQuery)){
			System.out.println("Records in Forward Direction");
			System.out.println("----------------------------");
			System.out.println("Row\t\tEno\t\tEname\t\tEaddr");
			System.out.println("----------------------------");
			while(rs.next()) {
				System.out.println(rs.getRow()+"--->"+rs.getInt(1)+"\t"+rs.getString(2)
				+"\t"+rs.getDouble(3)+rs.getString(4));
			}
			System.out.println("Records in Backward Direction");
			System.out.println("----------------------------");
			System.out.println("Row\t\tEno\t\tEname\t\tEaddr");
			System.out.println("----------------------------");
			while(rs.previous()) {
				System.out.println(rs.getRow()+"--->"+rs.getInt(1)+"\t"+rs.getString(2)
				+"\t"+rs.getDouble(3)+rs.getString(4));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			}
	}

}
