package src.main.java.com.solvd.university.service;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import src.main.java.com.solvd.university.DAO.ICredientalsDao;
import src.main.java.com.solvd.university.DAO.IDepartmentDao;
import src.main.java.com.solvd.university.DAO.IInstructorDao;
import src.main.java.com.solvd.university.DAO.IPositionDao;
import src.main.java.com.solvd.university.DAO.IUserDao;
import src.main.java.com.solvd.university.DAO.mysqlimpl.CredientalsDao;
import src.main.java.com.solvd.university.DAO.mysqlimpl.DepartmentDao;
import src.main.java.com.solvd.university.DAO.mysqlimpl.InstructorDao;
import src.main.java.com.solvd.university.DAO.mysqlimpl.PositionDao;
import src.main.java.com.solvd.university.DAO.mysqlimpl.UserDao;
import src.main.java.com.solvd.university.model.Credientals;
import src.main.java.com.solvd.university.model.Department;
import src.main.java.com.solvd.university.model.Instructor;
import src.main.java.com.solvd.university.model.Position;
import src.main.java.com.solvd.university.model.User;
import src.main.java.com.solvd.university.service.interfaces.IInstructorService;

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
