package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

public class OracleExample {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "system";
        String password = "oracle";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            Random random = new Random();
            long startTime = System.currentTimeMillis();
            String insertSQL = "INSERT INTO random_numbers (value) VALUES (?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
                for (int i = 0; i < 20000; i++) {
                    preparedStatement.setInt(1, random.nextInt(100000));
                    preparedStatement.addBatch();
                }
                preparedStatement.executeBatch();
            }
            long endTime = System.currentTimeMillis();
            System.out.println("20.000 insert süresi: " + (endTime - startTime) + " ms");

            startTime = System.currentTimeMillis();
            String selectSQL = "SELECT * FROM random_numbers";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    resultSet.getInt("id");
                }
            }
            endTime = System.currentTimeMillis();
            System.out.println("20.000 select süresi: " + (endTime - startTime) + " ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
