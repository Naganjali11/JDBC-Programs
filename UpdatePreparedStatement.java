package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdatePreparedStatement {
	static final String jdbc_url="jdbc:mysql://localhost:3306/jfs_41";
	static final String userName="root";
	static final String password="Naga@123";
	public static void main(String[] args) {
		String updateQuery="update employee set ename=?,eaddr=? where eno=?";
		try(Connection connection=DriverManager.getConnection(jdbc_url,userName,password);
				PreparedStatement pst=connection.prepareStatement(updateQuery)){
			pst.setString(1, "Naganjali");
			pst.setString(2, "America");
			pst.setInt(3,222);
			int rowsAffected=pst.executeUpdate();
			if(rowsAffected==1) {
				System.out.println(rowsAffected+"record updated sucessfully");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
