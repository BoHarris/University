package com.solvd.university.DAO.mysqlimpl;

import java.sql.SQLException;
import java.util.List;

import com.solvd.university.DAO.IPositionDao;
import com.solvd.university.model.Position;

public class PositionDao extends AbstractMySQLDao implements IPositionDao<Position> {

	@Override
	public void createEntity(Position entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Position readEntity(long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEntity(Position entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEntinty(long id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Position> getPositionById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
