package com.solvd.university.service;

import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.solvd.university.DAO.IContinentDao;
import com.solvd.university.DAO.ICountryDao;
import com.solvd.university.DAO.mysqlimpl.ContinentDao;
import com.solvd.university.DAO.mysqlimpl.CountryDao;
import com.solvd.university.model.address.Continent;
import com.solvd.university.model.address.Country;
import com.solvd.university.service.interfaces.IContinentService;

public class ContinentService implements IContinentService {
	private IContinentDao<Continent> continentDao = new ContinentDao();
	private ICountryDao<Country> countryDao = new CountryDao();
	private static final Logger LOG = LogManager.getLogger(Continent.class.getName());

	@Override
	public Continent getContinentById(long id) {
		Continent c = null;

		try {
			c = continentDao.readEntity(id);
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}
		try {
			c.setCountries(countryDao.getCountryById(id));
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}
		return c;
	}

}
