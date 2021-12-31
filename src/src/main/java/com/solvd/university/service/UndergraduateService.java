package src.main.java.com.solvd.university.service;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import src.main.java.com.solvd.university.DAO.ICourseDao;
import src.main.java.com.solvd.university.DAO.IUndergraduateDao;
import src.main.java.com.solvd.university.DAO.IUserDao;
import src.main.java.com.solvd.university.DAO.mysqlimpl.CourseDao;
import src.main.java.com.solvd.university.DAO.mysqlimpl.UndergraduateDao;
import src.main.java.com.solvd.university.DAO.mysqlimpl.UserDao;
import src.main.java.com.solvd.university.model.Course;
import src.main.java.com.solvd.university.model.Undergraduate;
import src.main.java.com.solvd.university.model.User;
import src.main.java.com.solvd.university.service.interfaces.IUndergraduateService;

public class UndergraduateService implements IUndergraduateService {
	private IUndergraduateDao<Undergraduate> undergraduateDao = new UndergraduateDao();
	private IUserDao<User> userDao = new UserDao();
	private ICourseDao<Course> courseDao = new CourseDao();
	private static final Logger log = LogManager.getLogger(UndergraduateService.class.getName());

	@Override
	public Undergraduate getUndergraduateById(long id) {
		Undergraduate u = null;
		try {
			u = undergraduateDao.readEntity(id);
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		try {
			u.setUsers(userDao.getUserById(u.getId()));
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		u.setCourses(courseDao.getCourseById(u.getId()));
		return u;
	}

}
