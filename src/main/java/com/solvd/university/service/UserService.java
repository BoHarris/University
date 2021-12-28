package com.solvd.university.service;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.university.DAO.IAddressDao;
import com.solvd.university.DAO.ILoginDao;
import com.solvd.university.DAO.IUserDao;
import com.solvd.university.DAO.mysqlimpl.AddressDao;
import com.solvd.university.DAO.mysqlimpl.LoginDao;
import com.solvd.university.DAO.mysqlimpl.UserDao;
import com.solvd.university.model.Login;
import com.solvd.university.model.User;
import com.solvd.university.model.address.Address;
import com.solvd.university.service.interfaces.IUserService;

public class UserService implements IUserService {

	private IUserDao<User> userDao = new UserDao();
	private IAddressDao<Address> addressDao = new AddressDao();
	private ILoginDao<Login> loginDao = new LoginDao();
	private static final Logger log = LogManager.getLogger(UserService.class.getName());

	@Override
	public User getUserById(long id) {
		User u = null;
		try {
			u = userDao.readEntity(id);
		} catch (SQLException e) {

			log.error(e.getMessage());
		}
		u.setAddressId(addressDao.getAddressById(id));
		u.setLoginId(loginDao.getLoginById(id));

		return u;
	}

}
