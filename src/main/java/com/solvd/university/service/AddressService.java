package com.solvd.university.service;

import java.util.List;

import com.solvd.university.DAO.IAddressDao;
import com.solvd.university.DAO.ICityDao;
import com.solvd.university.DAO.mysqlimpl.AddressDao;
import com.solvd.university.DAO.mysqlimpl.CityDao;
import com.solvd.university.model.address.Address;
import com.solvd.university.service.interfaces.IAddressService;

public class AddressService implements IAddressService {
	private IAddressDao addressDao = new AddressDao();
	private ICityDao cityDao = new CityDao();

	@Override
	public Address getAddressById(long id) {
		Address a = addressDao.getAddressById(id);
		a.setCity(cityDao.getListedCityById(id));
		return a;

	}

}
