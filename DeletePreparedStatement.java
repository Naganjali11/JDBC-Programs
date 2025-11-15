package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeletePreparedStatement {
    static final String jdbc_url = "jdbc:mysql://localhost:3306/jfs_41";
    static final String userName = "root";
    static final String password = "Naga@123";

    public static void main(String[] args) {
        String deleteQuery = "delete from employee where eno=?";
        try (Connection connection = DriverManager.getConnection(jdbc_url, userName, password);
             PreparedStatement pst = connection.prepareStatement(deleteQuery)) {
             
            pst.setInt(1, 222);
            
            int rowsAffected = pst.executeUpdate();
            if (rowsAffected == 1) {
                System.out.println(rowsAffected + " record deleted successfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
