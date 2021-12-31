package src.main.java.com.solvd.university.service;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import src.main.java.com.solvd.university.DAO.ICredientalsDao;
import src.main.java.com.solvd.university.DAO.mysqlimpl.CredientalsDao;
import src.main.java.com.solvd.university.model.Credientals;
import src.main.java.com.solvd.university.service.interfaces.ICredientalsService;

public class CredientalsService implements ICredientalsService {
	private ICredientalsDao<Credientals> credientalsDao = new CredientalsDao();
	private static final Logger log = LogManager.getLogger(CredientalsService.class.getName());

	@Override
	public Credientals getCredientalsById(long id) {
		Credientals c = null;

		try {
			c = credientalsDao.readEntity(id);
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		return c;
	}

}
