package com.solvd.university.DAO;

import java.sql.SQLException;
import java.util.List;

import com.solvd.university.model.address.City;

public interface ICityDao<T> extends IBaseDao<T> {

	List<T> getCities() throws SQLException;

	List<City> getCityById(long id) throws SQLException;
}
