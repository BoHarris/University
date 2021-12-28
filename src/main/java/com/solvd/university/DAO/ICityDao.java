package com.solvd.university.DAO;

import java.util.List;

import com.solvd.university.model.address.City;

public interface ICityDao<T> extends IBaseDao<T> {
	
	List<T> getCityById(long id);
}
