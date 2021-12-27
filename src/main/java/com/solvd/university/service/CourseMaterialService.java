package com.solvd.university.service;

import com.solvd.university.DAO.ICourseMaterialDao;
import com.solvd.university.DAO.mysqlimpl.CourseMaterialDao;
import com.solvd.university.model.CourseMaterial;
import com.solvd.university.service.interfaces.ICourseMaterialService;

public class CourseMaterialService implements ICourseMaterialService {
	private ICourseMaterialDao courseMaterialDao = new CourseMaterialDao();

	@Override
	public CourseMaterial getCourseMaterialById(long id) {
		CourseMaterial c = courseMaterialDao.getCourseMaterialById(id);

		return c;

	}

}
