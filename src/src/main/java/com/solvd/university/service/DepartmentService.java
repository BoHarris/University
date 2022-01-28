package com.solvd.university.service;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.university.DAO.IDepartmentDao;
import com.solvd.university.DAO.IUniversityDao;
import com.solvd.university.DAO.mysqlimpl.DepartmentDao;
import com.solvd.university.DAO.mysqlimpl.UniversityDao;
import com.solvd.university.model.Department;
import com.solvd.university.model.University;
import com.solvd.university.service.interfaces.IDepartmentService;

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
