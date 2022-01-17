package com.company.dataAccess;

import com.company.entities.City;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CityDao implements ICityDao {
    Connection connection;
    public void Connect() {
        try{
            this.connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/world","root","1234");}
        catch (Exception exception){
            System.out.println(exception);
        }

    }



    @Override
    public List<City> getAll() {
        List list=new ArrayList();
        Connect();
        try{
            Statement statement=connection.createStatement();
            ResultSet resultSet =statement.executeQuery("Select * from city");
            while(resultSet.next()) {
                City city = new City(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getLong(5));
                list.add(city);
            }

            statement.close();
            connection.close();
            return list;


        }catch (Exception exception){
            System.out.println(exception);
        }
        return list;
    }
}
