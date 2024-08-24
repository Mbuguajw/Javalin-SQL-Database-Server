package com.revature;

import java.sql.*;
import java.util.*;

public class ResultSetPrinter {
    public static void printResultSet(ResultSet rs) throws SQLException {
        List<String> columnNames = new ArrayList<>();
        for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
            columnNames.add(rs.getMetaData().getColumnName(i + 1));
        }

        List<List<String>> dataColumns = new ArrayList<>();
        for (int i = 0; i < columnNames.size(); i++) {
            dataColumns.add(new ArrayList<>());
            dataColumns.get(i).add(columnNames.get(i));
        }

        while (rs.next()) {
            for (int i = 0; i < columnNames.size(); i++) {
                dataColumns.get(i).add(rs.getString(i + 1));
            }
        }

        List<List<String>> formattedColumns = new ArrayList<>();
        for (List<String> column : dataColumns) {
            formattedColumns.add(UltimateStringTabber.tabColumn(column, true));
        }

        for (int row = 0 ; row < formattedColumns.get(0).size(); row++) {
            for (int col = 0; col < formattedColumns.size(); col++) {
                System.out.print(formattedColumns.get(col).get(row));
            }
            System.out.println();
        }
    }
}