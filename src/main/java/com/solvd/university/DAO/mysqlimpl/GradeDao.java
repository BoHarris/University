package com.solvd.university.DAO.mysqlimpl;

import java.sql.SQLException;
import java.util.List;

import com.solvd.university.DAO.IGradeDao;
import com.solvd.university.model.Grade;

public class GradeDao extends AbstractMySQLDao implements IGradeDao<Grade> {

	@Override
	public void createEntity(Grade entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Grade readEntity(long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEntity(Grade entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEntinty(long id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Grade> getGradeById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
