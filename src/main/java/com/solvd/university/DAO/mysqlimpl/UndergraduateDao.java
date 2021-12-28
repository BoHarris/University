package com.solvd.university.DAO.mysqlimpl;

import java.sql.SQLException;
import java.util.List;

import com.solvd.university.DAO.IUndergraduateDao;
import com.solvd.university.model.Undergraduate;

public class UndergraduateDao extends AbstractMySQLDao implements IUndergraduateDao<Undergraduate> {

	@Override
	public void createEntity(Undergraduate entity) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Undergraduate readEntity(long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEntity(Undergraduate entity) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteEntinty() throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Undergraduate> getUndergraduateById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
