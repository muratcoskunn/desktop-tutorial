package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","1234");
            Statement statement=connection.createStatement();
            ResultSet resultSet =statement.executeQuery("Select * from city");
            while(resultSet.next())
                System.out.println(resultSet.getString(2));


        }catch (Exception exception){
            System.out.println(exception);
        }

    }
}
