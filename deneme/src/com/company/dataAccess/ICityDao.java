package com.company.dataAccess;

import com.company.entities.City;

import java.util.List;

public interface ICityDao {
    public List<City> getAll();
    public List<String>getAllByName();
    public List<String>getAllByCountryCode();
}
