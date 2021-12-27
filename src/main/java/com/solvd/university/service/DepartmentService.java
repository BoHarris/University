package com.solvd.university.service;

import java.util.List;

import com.solvd.university.DAO.IDepartmentDao;
import com.solvd.university.DAO.IUniversityDao;
import com.solvd.university.DAO.mysqlimpl.DepartmentDao;
import com.solvd.university.DAO.mysqlimpl.UniversityDao;
import com.solvd.university.model.Department;
import com.solvd.university.service.interfaces.IDepartmentService;

public class DepartmentService implements IDepartmentService {
	private IDepartmentDao departmentDao = new DepartmentDao();
	private IUniversityDao universityDao = new UniversityDao();
	
	@Override
	public Department getDepartmentById(long id) {
		Department d = departmentDao.getDepartmentById();
		d.setUniversitys(universityDao.getListedUniversityById(id));
		return d;
		
	}

}
