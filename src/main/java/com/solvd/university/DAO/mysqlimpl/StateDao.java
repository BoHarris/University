package com.solvd.university.DAO.mysqlimpl;

import java.sql.SQLException;
import java.util.List;

import com.solvd.university.DAO.IStateDao;
import com.solvd.university.model.address.State;

public class StateDao extends AbstractMySQLDao implements IStateDao<State> {

	@Override
	public void createEntity(State entity) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public State readEntity(long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEntity(State entity) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteEntinty(long id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<State> getStateById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
