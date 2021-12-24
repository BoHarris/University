package com.solvd.university.DAO.mysqlimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.solvd.university.DAO.IUserDao;
import com.solvd.university.model.User;

public class UserDao extends AbstractMySQLDao implements IUserDao<User> {

	private List<User> users = new ArrayList<>();

	@Override
	public void createEntity(User entity) {

	}

	@Override
	public void readEntity(long id) {

	}

	@Override
	public User updateEntity(User entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEntinty() {
		// TODO Auto-generated method stub

	}

	@Override
	public User getUserById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
