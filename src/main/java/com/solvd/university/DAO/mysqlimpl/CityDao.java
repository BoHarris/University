package com.solvd.university.DAO.mysqlimpl;

import java.sql.SQLException;
import java.util.List;

import com.solvd.university.DAO.ICityDao;
import com.solvd.university.model.address.City;

public class CityDao extends AbstractMySQLDao implements ICityDao<City> {

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
	public void deleteEntinty() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<City> getCityById(long id) {
		// TODO Auto-generated method stub
		return null;
	}



}
