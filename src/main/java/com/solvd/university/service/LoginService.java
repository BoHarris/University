package com.solvd.university.service;

import com.solvd.university.DAO.ILoginDao;
import com.solvd.university.DAO.mysqlimpl.LoginDao;
import com.solvd.university.model.Login;
import com.solvd.university.service.interfaces.ILoginService;

public class LoginService implements ILoginService {
	private ILoginDao loginDao = new LoginDao();

	@Override
	public Login getLoginById(long id) {
		Login l = loginDao.getLoginById(id);
		return l;

	}

}
