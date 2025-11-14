package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteMultipleRecords {
    static final String jdbc_url = "jdbc:mysql://localhost:3306/jfs_41";
    static final String userName = "root";
    static final String password = "Naga@123";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(jdbc_url, userName, password);
             Statement statement = connection.createStatement()) {

            @SuppressWarnings("resource")
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter number of employees to delete:");
            int numEmp = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < numEmp; i++) {
                System.out.println("Enter employee number to delete (" + (i + 1) + "):");
                int empNumber = scanner.nextInt();
                scanner.nextLine();

                String deleteQuery = "delete from employee where eno=" + empNumber;
                int rowsAffected = statement.executeUpdate(deleteQuery);
                if (rowsAffected == 1) {
                    System.out.println("Deleted employee " + empNumber);
                } else {
                    System.out.println("No such employee " + empNumber);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
