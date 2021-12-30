package com.solvd.university.service;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.university.DAO.IAddressDao;
import com.solvd.university.DAO.IUniversityDao;
import com.solvd.university.DAO.mysqlimpl.AddressDao;
import com.solvd.university.DAO.mysqlimpl.UniversityDao;
import com.solvd.university.model.University;
import com.solvd.university.model.address.Address;
import com.solvd.university.service.interfaces.IUniversityService;

public class UniversityService implements IUniversityService {
	private static final Logger log = LogManager.getLogger(UniversityService.class.getName());
	private IUniversityDao<University> universityDao = new UniversityDao();
	private IAddressDao<Address> addressDao = new AddressDao();

	@Override
	public University getUniversityById(long id) {
		University u = null;
		try {
			u = universityDao.readEntity(id);
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		try {
			u.setAddresses(addressDao.getAddressById(u.getId()));
		} catch (SQLException e) {
			log.error(e.getMessage());
		}

		return u;
	}

}
