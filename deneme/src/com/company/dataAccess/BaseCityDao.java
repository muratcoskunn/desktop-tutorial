package com.company.dataAccess;

import com.company.entities.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BaseCityDao implements ICityDao {
    public Connection connection;
    public String connectionUrl="jdbc:mysql://localhost:3306/world";
    String user ="root";
    String password="1234";

    public void Connect() {
        try {
            this.connection = DriverManager.getConnection
                    (connectionUrl, user, password);
        } catch (Exception exception) {
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

    @Override
    public List<String> getAllByName() {
        List nameList= new ArrayList();
        List<City> cityList = getAll();
        for (City city:cityList
        ) {
            System.out.println(city.name);
        }
        return nameList;
    }

    @Override
    public List<String> getAllByCountryCode() {
        List codeList= new ArrayList();
        List<City> cityList = getAll();
        for (City city:cityList
        ) {
            System.out.println(city.countryCode);
        }
        return codeList;
    }
}
