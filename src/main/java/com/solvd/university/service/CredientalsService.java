package com.solvd.university.service;

import com.solvd.university.DAO.ICredientalsDao;
import com.solvd.university.DAO.mysqlimpl.CredientalsDao;
import com.solvd.university.model.Credientals;
import com.solvd.university.service.interfaces.ICredientalsService;

public class CredientalsService implements ICredientalsService {
	private ICredientalsDao credientalsDao = new CredientalsDao();

	@Override
	public Credientals getCredientalsById(long id) {
		Credientals c = credientalsDao.getCreditntalsById(id);

		return c;

	}

}
