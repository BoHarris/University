package com.solvd.university.DAO.mysqlimpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.university.DAO.ICityDao;
import com.solvd.university.model.address.City;

public class CityDao extends AbstractMySQLDao implements ICityDao<City> {

	private static final Logger log = LogManager.getLogger(CityDao.class);
	private static final String GET_USERS_BY_ID = "Select * from Address where id=?";
	private static final String CREATE_ADDRESS = "Insert into Address"
			+ " ( building_number, street_name, city_id) VALUES (?,?,?)";
	private static final String UPDATE_ADDRESS = "Update Address set building_number = ? where street_name = ?";
	private static final String DELETE_ADDRESS = "Delete from Address where id = ?";
	private static final String GET_Address_BY_ID = "Select * from Address where id=?";

	@Override
	public void createEntity(City entity) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public City readEntity(long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEntity(City entity) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteEntinty(long id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<City> getCityById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
