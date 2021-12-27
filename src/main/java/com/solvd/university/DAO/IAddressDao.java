package com.solvd.university.DAO;

import java.util.List;

import com.solvd.university.model.Position;
import com.solvd.university.model.address.Address;

public interface IAddressDao<T> extends IBaseDao<Address> {
	Address getAddressById(long id);
	List<T> getListedAddressById(long id);
}
