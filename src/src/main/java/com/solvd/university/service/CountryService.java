package src.main.java.com.solvd.university.service;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import src.main.java.com.solvd.university.DAO.ICountryDao;
import src.main.java.com.solvd.university.DAO.IStateDao;
import src.main.java.com.solvd.university.DAO.mysqlimpl.CountryDao;
import src.main.java.com.solvd.university.DAO.mysqlimpl.StateDao;
import src.main.java.com.solvd.university.model.address.Country;
import src.main.java.com.solvd.university.model.address.State;
import src.main.java.com.solvd.university.service.interfaces.ICountryService;

public class CountryService implements ICountryService {
	private ICountryDao<Country> countryDao = new CountryDao();
	private IStateDao<State> statesDao = new StateDao();
	private static final Logger LOG = LogManager.getLogger(CountryService.class.getName());

	@Override
	public Country getCountryById(long id) {
		Country c = null;

		try {
			c = countryDao.readEntity(id);
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}
		try {
			c.setStates(statesDao.getStateById(id));
		} catch (SQLException e) {
			LOG.debug(e.getMessage());
		}
		return c;
	}

}
