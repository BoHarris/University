package src.main.java.com.solvd.university.service;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import src.main.java.com.solvd.university.DAO.IPrerequisiteDao;
import src.main.java.com.solvd.university.DAO.mysqlimpl.PrerequisiteDao;
import src.main.java.com.solvd.university.model.Prerequisite;
import src.main.java.com.solvd.university.service.interfaces.IPrerequisiteService;

public class PrerequisiteService implements IPrerequisiteService {
	private IPrerequisiteDao<Prerequisite> prerequisiteDao = new PrerequisiteDao();
	private static final Logger log = LogManager.getLogger(PrerequisiteService.class.getName());

	@Override
	public Prerequisite getPrerequisiteById(long id) {
		Prerequisite p = null;
		try {
			p = prerequisiteDao.readEntity(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
		}

		return p;
	}

}
