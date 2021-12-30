package com.solvd.university.DAO;

import java.sql.SQLException;
import java.util.List;

import com.solvd.university.model.Position;
import com.solvd.university.model.address.Address;

public interface IAddressDao<T> extends IBaseDao<T> {
	List<T> getAddressById(long id) throws SQLException;
}
