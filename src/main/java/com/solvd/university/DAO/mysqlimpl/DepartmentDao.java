package com.solvd.university.DAO.mysqlimpl;

import java.sql.SQLException;
import java.util.List;

import com.solvd.university.DAO.IDepartmentDao;
import com.solvd.university.model.Department;

public class DepartmentDao extends AbstractMySQLDao implements IDepartmentDao<Department> {

	@Override
	public void createEntity(Department entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Department readEntity(long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEntity(Department entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEntinty(long id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Department> getDepartmentById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
