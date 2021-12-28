package com.solvd.university.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.university.DAO.ICountryDao;
import com.solvd.university.DAO.IStateDao;
import com.solvd.university.DAO.mysqlimpl.CountryDao;
import com.solvd.university.DAO.mysqlimpl.StateDao;
import com.solvd.university.model.address.Country;
import com.solvd.university.model.address.State;
import com.solvd.university.service.interfaces.ICountryService;

public class CountryService implements ICountryService {
	private ICountryDao<Country> countryDao = new CountryDao<>();
	private IStateDao<State> statesDao = new StateDao();
	private static final Logger log = LogManager.getLogger(CountryService.class.getName());

	@Override
	public Country getCountryById(long id) {
		Country c = null;

		try {
			c = countryDao.readEntity(id);
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		c.setStates(statesDao.getStateById(id));
		return c;
	}

}
