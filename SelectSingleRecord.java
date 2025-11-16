package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectSingleRecord {
    static final String jdbc_url = "jdbc:mysql://localhost:3306/jfs_41";
    static final String userName = "root";
    static final String password = "Naga@123";

    public static void main(String[] args) {
        String selectQuery = "SELECT * FROM employee WHERE eno=?";
        try (Connection connection = DriverManager.getConnection(jdbc_url, userName, password);
             PreparedStatement pst = connection.prepareStatement(selectQuery);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Enter Employee Number to search:");
            int number = scanner.nextInt();

            pst.setInt(1, number);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                System.out.println("Employee Number: " + rs.getInt("eno"));
                System.out.println("Employee Name: " + rs.getString("ename"));
                System.out.println("Employee Salary: " + rs.getDouble("esal"));
                System.out.println("Employee Location: " + rs.getString("eaddr"));
            } else {
                System.out.println("No record found for Employee Number: " + number);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
