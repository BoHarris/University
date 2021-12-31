package src.main.java.com.solvd.university.service;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import src.main.java.com.solvd.university.DAO.ILoginDao;
import src.main.java.com.solvd.university.DAO.mysqlimpl.LoginDao;
import src.main.java.com.solvd.university.model.Login;
import src.main.java.com.solvd.university.service.interfaces.ILoginService;

public class LoginService implements ILoginService {
	private ILoginDao<Login> loginDao = new LoginDao();
	private static final Logger log = LogManager.getLogger(LoginService.class.getName());

	@Override
	public Login getLoginById(long id) {
		Login l = null;

		try {
			l = loginDao.readEntity(id);
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		return l;
	}

}
