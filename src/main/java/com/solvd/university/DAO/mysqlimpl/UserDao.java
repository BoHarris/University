package com.solvd.university.DAO.mysqlimpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.solvd.university.DAO.IUserDao;
import com.solvd.university.model.User;

public class UserDao extends AbstractMySQLDao implements IUserDao<User> {

	@Override
	public void createEntity(User entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User readEntity(long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEntity(User entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEntinty() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getUserById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
