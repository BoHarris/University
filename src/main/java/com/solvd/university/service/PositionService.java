package com.solvd.university.service;

import com.solvd.university.DAO.IPositionDao;
import com.solvd.university.DAO.mysqlimpl.PositionDao;
import com.solvd.university.model.Position;
import com.solvd.university.service.interfaces.IPositionService;

public class PositionService implements IPositionService {
	private IPositionDao positionDao = new PositionDao();

	@Override
	public Position getPositionById(long id) {
		Position p = positionDao.getPositionById(id);
		return p;

	}

}
