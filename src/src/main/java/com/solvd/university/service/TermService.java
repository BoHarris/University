package src.main.java.com.solvd.university.service;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import src.main.java.com.solvd.university.DAO.ITermDao;
import src.main.java.com.solvd.university.DAO.mysqlimpl.TermDao;
import src.main.java.com.solvd.university.model.Term;
import src.main.java.com.solvd.university.service.interfaces.ITermSerivce;

public class TermService implements ITermSerivce {
	private ITermDao<Term> termDao = new TermDao();
	private static final Logger log = LogManager.getLogger(UserService.class.getName());

	@Override
	public Term getTermById(long id) {
		Term t = null;
		try {
			t = termDao.readEntity(id);
		} catch (SQLException e) {

			log.error(e.getMessage());
		}
		return t;
	}

}
