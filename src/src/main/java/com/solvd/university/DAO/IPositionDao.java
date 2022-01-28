package com.solvd.university.DAO;

import java.util.List;

public interface IPositionDao<T> extends IBaseDao<T> {
	List<T> getPositionById(long id);
}
