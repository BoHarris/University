package src.main.java.com.solvd.university.service;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import src.main.java.com.solvd.university.DAO.IGradeDao;
import src.main.java.com.solvd.university.DAO.IUndergraduateDao;
import src.main.java.com.solvd.university.DAO.mysqlimpl.GradeDao;
import src.main.java.com.solvd.university.DAO.mysqlimpl.UndergraduateDao;
import src.main.java.com.solvd.university.model.Grade;
import src.main.java.com.solvd.university.model.Undergraduate;
import src.main.java.com.solvd.university.service.interfaces.IGradeService;

public class GradeService implements IGradeService {
	private IGradeDao<Grade> gradeDao = new GradeDao();
	private IUndergraduateDao<Undergraduate> undergraduateDao = new UndergraduateDao();
	private static final Logger LOG = LogManager.getLogger(GradeService.class.getName());

	@Override
	public Grade getGradeById(long id) {
		Grade g = null;

		try {
			g = gradeDao.readEntity(id);
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}
		g.setUndergraduates(undergraduateDao.getUndergraduateById(id));
		return g;
	}

}
