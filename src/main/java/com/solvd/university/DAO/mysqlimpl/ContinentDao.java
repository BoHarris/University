package com.solvd.university.DAO.mysqlimpl;

import java.sql.SQLException;
import java.util.List;

import com.solvd.university.DAO.IContinentDao;

public class ContinentDao<T> extends AbstractMySQLDao implements IContinentDao<T> {

	@Override
	public void createEntity(T entity) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public T readEntity(long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEntity(T entity) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteEntinty(long id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<T> getContinentById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
