package src.main.java.com.solvd.university.service;

import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import src.main.java.com.solvd.university.DAO.IAddressDao;
import src.main.java.com.solvd.university.DAO.ICityDao;
import src.main.java.com.solvd.university.DAO.mysqlimpl.AddressDao;
import src.main.java.com.solvd.university.DAO.mysqlimpl.CityDao;
import src.main.java.com.solvd.university.model.address.Address;
import src.main.java.com.solvd.university.model.address.City;
import src.main.java.com.solvd.university.service.interfaces.ICitySerivce;

public class CityService implements ICitySerivce {
	private ICityDao<City> cityDao = new CityDao();
	private IAddressDao<Address> addressDao = new AddressDao();
	private static final Logger LOG = LogManager.getLogger(CityService.class.getName());

	@Override
	public City getCityById(long id) {
		City c = null;

		try {
			c = cityDao.readEntity(id);
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}
		try {
			c.setAddresses(addressDao.getAddressById(id));
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}
		return c;
	}

}
