package com.company;
import javax.swing.*;
import java.sql.*;


public class Main {

    public static void main(String[] args) {

        PrjButton prj = new PrjButton();



        final String DATABASE_URL = "jdbc:derby:HOSPITALDATABASE";
        final String SELECT_QUERY = "SELECT * FROM manager";
        String deleteDoc = "delete from manager where M_ID=122";

        // use try-with-resources to connect to and query the database
        try(
                Connection connection = DriverManager.getConnection(DATABASE_URL, "APP", "APP");
                Statement statement = connection.createStatement();
                Statement stmt = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(SELECT_QUERY))
        {
            //DELETING a doctor

            stmt.executeUpdate(deleteDoc);

            // get ResultSet's meta data
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();

            System.out.printf("ALL DOCTORS WORKING IN THE HOSPITAL:%n%n");

            // display the names of the columns in the ResultSet
            for (int i = 1; i <= numberOfColumns; i++)
                System.out.printf("%-10s\t", metaData.getColumnName(i));
            System.out.println();

            // display query results
            while (resultSet.next())
            {
                for (int i = 1; i <= numberOfColumns; i++)
                    System.out.printf("%-10s\t", resultSet.getObject(i));
                System.out.println();
            }
        } // AutoCloseable objects' close methods are called now
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }











    }


}

