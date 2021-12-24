package com.solvd.university.service;

import com.solvd.university.DAO.ICredientalsDao;
import com.solvd.university.DAO.IDepartmentDao;
import com.solvd.university.DAO.IInstructorDao;
import com.solvd.university.DAO.IPositionDao;
import com.solvd.university.DAO.IUserDao;
import com.solvd.university.DAO.mysqlimpl.CredientalsDao;
import com.solvd.university.DAO.mysqlimpl.DepartmentDao;
import com.solvd.university.DAO.mysqlimpl.InstructorDao;
import com.solvd.university.DAO.mysqlimpl.PositionDao;
import com.solvd.university.DAO.mysqlimpl.UserDao;
import com.solvd.university.model.Instructor;
import com.solvd.university.service.interfaces.IInstructorService;

public class InstructorService implements IInstructorService {
	private IInstructorDao instructorDao = new InstructorDao();
	private IPositionDao positionDao = new PositionDao();
	private IDepartmentDao departmentDao = new DepartmentDao();
	private ICredientalsDao credientalsDao = new CredientalsDao();
	private IUserDao userDao = new UserDao();

	@Override
	public Instructor getInstructorById(long id) {
		Instructor i = instructorDao.getInstructorById(id);
		i.setPositions(positionDao.getPositionById(id));
		i.setDepartments(departmentDao.getDepartmentById(id));
		i.setCredentials(credientalsDao.getCredientalsById(id));
		i.setUsers(userDao.getUserById(id));

		return i;

	}

}
