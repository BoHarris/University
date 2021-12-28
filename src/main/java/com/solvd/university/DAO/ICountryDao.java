package com.solvd.university.DAO;

import java.util.List;

import com.solvd.university.model.address.Country;

public interface ICountryDao<T> extends IBaseDao<T> {
	List<T> getCountryById(long id);
}
