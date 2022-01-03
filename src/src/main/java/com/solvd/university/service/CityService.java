package src.main.java.com.solvd.university.service;

import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import src.main.java.com.solvd.university.DAO.ICityDao;
import src.main.java.com.solvd.university.DAO.mysqlimpl.CityDao;
import src.main.java.com.solvd.university.model.address.City;
import src.main.java.com.solvd.university.service.interfaces.ICitySerivce;

public class CityService implements ICitySerivce {
	private ICityDao<City> cityDao = new CityDao();
	private static final Logger log = LogManager.getLogger(CityService.class.getName());

	@Override
	public City getCityById(long id) {
		City c = null;

		try {
			c = cityDao.readEntity(id);
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		return c;
	}

}