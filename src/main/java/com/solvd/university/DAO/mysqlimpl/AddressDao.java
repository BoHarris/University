package com.solvd.university.DAO.mysqlimpl;

import java.sql.SQLException;
import java.util.List;

import com.solvd.university.DAO.IAddressDao;
import com.solvd.university.model.address.Address;

public class AddressDao extends AbstractMySQLDao implements IAddressDao<Address> {

	@Override
	public void createEntity(Address entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Address readEntity(long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEntity(Address entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEntinty() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Address> getAddressById(long id) {
		// TODO Auto-generated method stub
		return null;
	}



}
