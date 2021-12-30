package com.solvd.university.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.solvd.university.DAO.IAddressDao;
import com.solvd.university.DAO.ICityDao;
import com.solvd.university.DAO.mysqlimpl.AddressDao;
import com.solvd.university.DAO.mysqlimpl.CityDao;
import com.solvd.university.model.address.Address;
import com.solvd.university.model.address.City;
import com.solvd.university.model.address.Continent;
import com.solvd.university.service.interfaces.IAddressService;

public class AddressService implements IAddressService {
	private IAddressDao<Address> addressDao = new AddressDao();
	private ICityDao<City> cityDao = new CityDao();
	private static final Logger log = LogManager.getLogger(AddressService.class.getName());

	@Override
	public Address getAddressById(long id) {
		Address a = null;

		try {
			a = addressDao.readEntity(id);
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		try {
			a.setCity(cityDao.getCityById(id));
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		return a;
	}

}
