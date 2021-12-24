package com.solvd.university.service;

import com.solvd.university.DAO.ICourseDao;
import com.solvd.university.DAO.IUndergraduateDao;
import com.solvd.university.DAO.IUserDao;
import com.solvd.university.DAO.mysqlimpl.CourseDao;
import com.solvd.university.DAO.mysqlimpl.UndergraduateDao;
import com.solvd.university.DAO.mysqlimpl.UserDao;
import com.solvd.university.model.Undergraduate;
import com.solvd.university.service.interfaces.IUndergraduateService;

public class UndergraduateService implements IUndergraduateService {
	private IUndergraduateDao undergraduateDao = new UndergraduateDao();
	private IUserDao userDao = new UserDao();
	private ICourseDao courseDao = new CourseDao();

	@Override
	public Undergraduate getUndergraduateById(long id) {
		Undergraduate u = undergraduateDao.getListedUndergraduateById(id);
		u.setUserId(userDao.getUserById(id));
		return u;
	}

}
