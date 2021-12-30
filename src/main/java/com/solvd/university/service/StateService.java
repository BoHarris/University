package com.solvd.university.service;

import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.solvd.university.DAO.ICityDao;
import com.solvd.university.DAO.ICountryDao;
import com.solvd.university.DAO.IStateDao;
import com.solvd.university.DAO.mysqlimpl.CityDao;
import com.solvd.university.DAO.mysqlimpl.CountryDao;
import com.solvd.university.DAO.mysqlimpl.StateDao;
import com.solvd.university.model.address.City;
import com.solvd.university.model.address.Country;
import com.solvd.university.model.address.State;
import com.solvd.university.service.interfaces.IStateService;

public class StateService implements IStateService {
	private IStateDao<State> stateDao = new StateDao();
	private ICountryDao<Country> countryDao = new CountryDao();
	private ICityDao<City> cityDao = new CityDao();
	private static final Logger log = LogManager.getLogger(StateService.class.getName());

	@Override
	public State getStateById(long id) {
		State s = null;
		try {
			s = stateDao.readEntity(id);
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		try {
			s.setCities(cityDao.getCityById(id));
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		return s;
	}

}
