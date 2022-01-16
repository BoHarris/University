package src.main.java.com.solvd.university.service;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import src.main.java.com.solvd.university.DAO.IAddressDao;
import src.main.java.com.solvd.university.DAO.IUniversityDao;
import src.main.java.com.solvd.university.DAO.mysqlimpl.AddressDao;
import src.main.java.com.solvd.university.DAO.mysqlimpl.UniversityDao;
import src.main.java.com.solvd.university.model.University;
import src.main.java.com.solvd.university.model.address.Address;
import src.main.java.com.solvd.university.service.interfaces.IUniversityService;

public class UniversityService implements IUniversityService {
	private static final Logger LOG = LogManager.getLogger(UniversityService.class.getName());
	private IUniversityDao<University> universityDao = new UniversityDao();
	private IAddressDao<Address> addressDao = new AddressDao();

	@Override
	public University getUniversityById(long id) {
		University u = null;
		try {
			u = universityDao.readEntity(id);
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}
		try {
			u.setAddresses(addressDao.getAddressById(u.getId()));
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}

		return u;
	}

}
