package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteMultipleeRecords {
    static final String jdbc_url = "jdbc:mysql://localhost:3306/jfs_41";
    static final String userName = "root";
    static final String password = "Naga@123";

    public static void main(String[] args) {
        String deleteQuery = "DELETE FROM employee WHERE eno=?";
        try (Connection connection = DriverManager.getConnection(jdbc_url, userName, password);
             PreparedStatement pst = connection.prepareStatement(deleteQuery);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("How many records do you want to delete?");
            int count = scanner.nextInt();

            for (int i = 0; i < count; i++) {
                System.out.println("Enter Employee Number to delete:");
                int number = scanner.nextInt();
                pst.setInt(1, number);
                pst.executeUpdate();
            }
            System.out.println(count + " records deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
