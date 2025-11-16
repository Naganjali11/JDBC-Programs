package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateSingleRecords {
    static final String jdbc_url = "jdbc:mysql://localhost:3306/jfs_41";
    static final String userName = "root";
    static final String password = "Naga@123";

    public static void main(String[] args) {
        String updateQuery = "UPDATE employee SET ename=?, esal=?, eaddr=? WHERE eno=?";
        try (Connection connection = DriverManager.getConnection(jdbc_url, userName, password);
             PreparedStatement pst = connection.prepareStatement(updateQuery);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Enter Employee Number to update:");
            int number = scanner.nextInt();
            System.out.println("Enter New Name:");
            String name = scanner.next();
            System.out.println("Enter New Salary:");
            double salary = scanner.nextDouble();
            System.out.println("Enter New Location:");
            String location = scanner.next();

            pst.setString(1, name);
            pst.setDouble(2, salary);
            pst.setString(3, location);
            pst.setInt(4, number);

            int rowsAffected = pst.executeUpdate();
            System.out.println(rowsAffected + " record updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
