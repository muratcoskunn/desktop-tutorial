package com.company;

import com.company.dataAccess.CityDao;
import com.company.dataAccess.ICityDao;
import com.company.entities.City;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ICityDao cityDao=new CityDao();
        List<String> List= cityDao.getAllByCountryCode();
        for (String code:List
             ) {
            System.out.println(code);
        }

    }
}
