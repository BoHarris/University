package com.solvd.university.DAO;

import java.util.List;

public interface IStateDao<T> extends IBaseDao<T> {
	List<T> getStateById(long id);
}
