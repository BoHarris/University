package com.solvd.university.service;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.university.DAO.IPositionDao;
import com.solvd.university.DAO.mysqlimpl.PositionDao;
import com.solvd.university.model.Position;
import com.solvd.university.service.interfaces.IPositionService;

public class PositionService implements IPositionService {
	private IPositionDao<Position> positionDao = new PositionDao();
	private static final Logger log = LogManager.getLogger(PositionService.class.getName());

	@Override
	public Position getPositionById(long id) {
		Position p = null;

		try {
			p = positionDao.readEntity(id);
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		return p;
	}

}
