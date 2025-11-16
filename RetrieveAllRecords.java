package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RetrieveAllRecords {
    static final String jdbc_url = "jdbc:mysql://localhost:3306/jfs_41";
    static final String userName = "root";
    static final String password = "Naga@123";

    public static void main(String[] args) {
        String selectQuery = "SELECT * FROM employee";
        try (Connection connection = DriverManager.getConnection(jdbc_url, userName, password);
             PreparedStatement pst = connection.prepareStatement(selectQuery)) {

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                System.out.println("Employee Number: " + rs.getInt("eno"));
                System.out.println("Employee Name: " + rs.getString("ename"));
                System.out.println("Employee Salary: " + rs.getDouble("esal"));
                System.out.println("Employee Location: " + rs.getString("eaddr"));
                System.out.println("------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
