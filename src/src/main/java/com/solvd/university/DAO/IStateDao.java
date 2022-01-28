package com.solvd.university.DAO;

import java.sql.SQLException;
import java.util.List;

import com.solvd.university.model.address.State;

public interface IStateDao<T> extends IBaseDao<T> {
	List<T> getStates() throws SQLException;

	List<State> getStateById(long id) throws SQLException;
}
