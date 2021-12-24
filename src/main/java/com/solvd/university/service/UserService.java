package com.solvd.university.service;

import java.util.List;

import com.solvd.university.DAO.IAddressDao;
import com.solvd.university.DAO.ILoginDao;
import com.solvd.university.DAO.IUserDao;
import com.solvd.university.DAO.mysqlimpl.AddressDao;
import com.solvd.university.DAO.mysqlimpl.LoginDao;
import com.solvd.university.DAO.mysqlimpl.UserDao;
import com.solvd.university.model.User;
import com.solvd.university.service.interfaces.IUserService;

public class UserService implements IUserService {

	private IUserDao userDao = new UserDao();
	private IAddressDao addressDao = new AddressDao();
	private ILoginDao loginDao = new LoginDao();
	private long id;

	@Override
	public User getUserById(long id) {
		User u = userDao.getUserById(id);
		u.setAddressId(addressDao.getAddressById(id));
		u.setLoginId(loginDao.getLoginById(id));
		return u;

	}

}
