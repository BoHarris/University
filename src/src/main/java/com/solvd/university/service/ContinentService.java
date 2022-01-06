package src.main.java.com.solvd.university.service;

import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import src.main.java.com.solvd.university.DAO.IContinentDao;
import src.main.java.com.solvd.university.DAO.ICountryDao;
import src.main.java.com.solvd.university.DAO.mysqlimpl.ContinentDao;
import src.main.java.com.solvd.university.DAO.mysqlimpl.CountryDao;
import src.main.java.com.solvd.university.model.address.Continent;
import src.main.java.com.solvd.university.model.address.Country;
import src.main.java.com.solvd.university.service.interfaces.IContinentService;

public class ContinentService implements IContinentService {
	private IContinentDao<Continent> continentDao = new ContinentDao();
	private ICountryDao<Country> countryDao = new CountryDao();
	private static final Logger log = LogManager.getLogger(Continent.class.getName());

	@Override
	public Continent getContinentById(long id) {
		Continent c = null;

		try {
			c = continentDao.readEntity(id);
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		try {
			c.setCountries(countryDao.getCountryById(id));
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		return c;
	}

}
