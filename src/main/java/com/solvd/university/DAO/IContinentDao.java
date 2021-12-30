package com.solvd.university.DAO;

import java.sql.SQLException;
import java.util.List;

import com.solvd.university.model.address.Continent;

public interface IContinentDao<T> extends IBaseDao<T> {
	List<T> getContinentById(long id) throws SQLException;
}
