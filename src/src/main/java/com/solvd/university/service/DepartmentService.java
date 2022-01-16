package src.main.java.com.solvd.university.service;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import src.main.java.com.solvd.university.DAO.IDepartmentDao;
import src.main.java.com.solvd.university.DAO.IUniversityDao;
import src.main.java.com.solvd.university.DAO.mysqlimpl.DepartmentDao;
import src.main.java.com.solvd.university.DAO.mysqlimpl.UniversityDao;
import src.main.java.com.solvd.university.model.Department;
import src.main.java.com.solvd.university.model.University;
import src.main.java.com.solvd.university.service.interfaces.IDepartmentService;

public class DepartmentService implements IDepartmentService {
	private IDepartmentDao<Department> departmentDao = new DepartmentDao();
	private IUniversityDao<University> universityDao = new UniversityDao();
	private static final Logger LOG = LogManager.getLogger(DepartmentService.class.getName());

	@Override
	public Department getDepartmentById(long id) {
		Department d = null;
		try {
			d = departmentDao.readEntity(id);
		} catch (SQLException e) {

			LOG.error(e.getMessage());
		}
		d.setUniversitys(universityDao.getUniversityById(id));
		return d;
	}

}
