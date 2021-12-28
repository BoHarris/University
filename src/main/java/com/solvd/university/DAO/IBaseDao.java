package com.solvd.university.DAO;

import java.sql.SQLException;

public interface IBaseDao<T> {
	void createEntity(T entity) throws SQLException;

	T readEntity(long id) throws SQLException;

	void updateEntity(T entity) throws SQLException;

	void deleteEntinty() throws SQLException;
}
