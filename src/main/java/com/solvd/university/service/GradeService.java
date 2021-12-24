package com.solvd.university.service;

import java.util.List;

import com.solvd.university.DAO.IGradeDao;
import com.solvd.university.DAO.IUndergraduateDao;
import com.solvd.university.DAO.mysqlimpl.GradeDao;
import com.solvd.university.DAO.mysqlimpl.UndergraduateDao;
import com.solvd.university.model.Grade;
import com.solvd.university.service.interfaces.IGradeService;

public class GradeService implements IGradeService {
	private IGradeDao gradeDao = new GradeDao();
	private IUndergraduateDao undergraduateDao = new UndergraduateDao();

	@Override
	public Grade getGradeById(long id) {
		Grade g = gradeDao.getGradeById(id);
		g.setUndergraduates(undergraduateDao.getUndergraduateById(id));
		return g;
	}

}
