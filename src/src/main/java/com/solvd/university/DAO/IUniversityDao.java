package com.solvd.university.DAO;

import java.util.List;

public interface IUniversityDao<T> extends IBaseDao<T> {
	List<T> getUniversityById(long id);
}
