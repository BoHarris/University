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
import src.main.java.com.solvd.university.service.interfaces.IAddressService;



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
