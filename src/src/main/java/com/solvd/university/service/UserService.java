package com.solvd.university.service;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.university.DAO.IUserDao;
import com.solvd.university.DAO.mysqlimpl.UserDao;
import com.solvd.university.model.User;
import com.solvd.university.service.interfaces.IUserService;

public class UserService implements IUserService {

	private IUserDao<User> userDao = new UserDao();
	private static final Logger log = LogManager.getLogger(UserService.class.getName());

	@Override
	public User getUserById(long id) {
		User u = null;
		try {
			u = userDao.readEntity(id);
		} catch (SQLException e) {

			log.error(e.getMessage());
		}

		return u;
	}
}
