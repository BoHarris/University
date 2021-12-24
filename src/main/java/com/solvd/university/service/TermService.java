package com.solvd.university.service;

import com.solvd.university.DAO.ITermDao;
import com.solvd.university.DAO.mysqlimpl.TermDao;
import com.solvd.university.model.Term;
import com.solvd.university.service.interfaces.ITermSerivce;

public class TermService implements ITermSerivce {
	private ITermDao termDao = new TermDao();

	@Override
	public Term getTermById(long id) {
		Term t = termDao.getTermById(id);
		return t;

	}

}
