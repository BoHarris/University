package com.solvd.university.service;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
import com.solvd.university.model.Credientals;
import com.solvd.university.model.Department;
import com.solvd.university.model.Instructor;
import com.solvd.university.model.Position;
import com.solvd.university.model.User;
import com.solvd.university.service.interfaces.IInstructorService;

public class InstructorService implements IInstructorService {
	private IInstructorDao<Instructor> instructorDao = new InstructorDao();
	private IPositionDao<Position> positionDao = new PositionDao();
	private IDepartmentDao<Department> departmentDao = new DepartmentDao();
	private ICredientalsDao<Credientals> credientalsDao = new CredientalsDao();
	private IUserDao<User> userDao = new UserDao();
	private static final Logger LOG = LogManager.getLogger(InstructorService.class.getName());

	@Override
	public Instructor getInstructorById(long id) {
		Instructor i = null;

		try {
			i = instructorDao.readEntity(id);
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}
		i.setPositions(positionDao.getPositionById(id));
		i.setDepartments(departmentDao.getDepartmentById(id));
		i.setCredentials(credientalsDao.getCredientalsById(id));
		try {
			i.setUsers(userDao.getUserById(id));
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}
		return i;
	}

}
