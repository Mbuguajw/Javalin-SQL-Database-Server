package com.revature;

import java.sql.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:test;INIT=runscript from 'init.sql'", "sa", "");
        // ResultSet resultSet = connection.prepareStatement("select * from cars").executeQuery();
        // while (resultSet.next()) 
        //     System.out.println(resultSet.getInt("id") + " " + resultSet.getString("name") + " " + resultSet.getInt("yearmake"));

        Scanner scanner = new Scanner(System.in);
        boolean isDone = false;
        String query;
        while (!isDone) {
            Statement statement = connection.createStatement();
            System.out.print("h2> ");
            query = scanner.nextLine();
        
            if ("exit".equalsIgnoreCase(query)) {
                isDone = true;
                break;
            }

            while (!query.endsWith(";")) {
                System.out.print("---->  ");
                query += scanner.nextLine();
            }

            
            boolean isResultSet = statement.execute(query);
            if (isResultSet) {
                ResultSet rs = statement.getResultSet();
                ResultSetPrinter.printResultSet(rs);
                System.out.println();
            } else {
                int linesUpdated = statement.getUpdateCount();
                System.out.println(linesUpdated + ((linesUpdated == 1) ? " row" : " rows") + " updated.");
            }
        }
        scanner.close();
        connection.close();
    }
}
