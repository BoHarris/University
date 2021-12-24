package com.solvd.university.service;

import com.solvd.university.DAO.IPrerequisiteDao;
import com.solvd.university.DAO.mysqlimpl.PrerequisiteDao;
import com.solvd.university.model.Prerequisite;
import com.solvd.university.service.interfaces.IPrerequisiteService;

public class PrerequisiteService implements IPrerequisiteService {
	private IPrerequisiteDao prerequisiteDao = new PrerequisiteDao();

	@Override
	public Prerequisite getPrerequisiteById(long id) {
		Prerequisite p = prerequisiteDao.getPrerequisiteById(id);
		return p;

	}

}
