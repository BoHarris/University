package com.solvd.university.service;

import com.solvd.university.DAO.ICityDao;
import com.solvd.university.DAO.mysqlimpl.CityDao;
import com.solvd.university.model.address.City;
import com.solvd.university.service.interfaces.ICitySerivce;

public class CityService implements ICitySerivce {
	private ICityDao cityDao = new CityDao();

	@Override
	public City getCityById(long id) {
		City c = cityDao.getCityById(id);

		return c;

	}

}
