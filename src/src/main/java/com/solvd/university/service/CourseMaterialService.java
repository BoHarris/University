package src.main.java.com.solvd.university.service;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import src.main.java.com.solvd.university.DAO.ICourseMaterialDao;
import src.main.java.com.solvd.university.DAO.mysqlimpl.CourseMaterialDao;
import src.main.java.com.solvd.university.model.CourseMaterial;
import src.main.java.com.solvd.university.service.interfaces.ICourseMaterialService;

public class CourseMaterialService implements ICourseMaterialService {
	private ICourseMaterialDao<CourseMaterial> courseMaterialDao = new CourseMaterialDao();
	private static final Logger log = LogManager.getLogger(CourseMaterialService.class.getName());

	@Override
	public CourseMaterial getCourseMaterialById(long id) {
		CourseMaterial c = null;

		try {
			c = courseMaterialDao.readEntity(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
		}

		return c;
	}

}
