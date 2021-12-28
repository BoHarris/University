package com.solvd.university.DAO.mysqlimpl;

import java.sql.SQLException;
import java.util.List;

import com.solvd.university.DAO.ILoginDao;
import com.solvd.university.model.Login;

public class LoginDao extends AbstractMySQLDao implements ILoginDao<Login> {

	@Override
	public void createEntity(Login entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Login readEntity(long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEntity(Login entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEntinty() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Login> getLoginById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
