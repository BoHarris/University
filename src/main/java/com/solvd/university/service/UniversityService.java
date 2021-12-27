package com.solvd.university.service;

import com.solvd.university.DAO.IAddressDao;
import com.solvd.university.DAO.IUniversityDao;
import com.solvd.university.DAO.mysqlimpl.AddressDao;
import com.solvd.university.DAO.mysqlimpl.UniversityDao;
import com.solvd.university.model.University;
import com.solvd.university.model.address.Address;
import com.solvd.university.service.interfaces.IUniversityService;

public class UniversityService implements IUniversityService {

	private IUniversityDao universityDao = new UniversityDao();
	private IAddressDao<Address> addressDao = new AddressDao();

	@Override
	public University getUniversityById(long id) {
		University u = universityDao.getUniversityById(id);
		u.setAddresses(addressDao.getAddressById(id));
		return u;

	}

}
