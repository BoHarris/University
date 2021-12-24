package com.solvd.university.DAO;

import java.util.List;

import com.solvd.university.model.City;

public interface ICityDao<T> extends IBaseDao<City> {
	List<T> getCityById(long id);
}
