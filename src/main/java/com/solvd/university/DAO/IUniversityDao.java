package com.solvd.university.DAO;

import java.util.List;

import com.solvd.university.model.University;

public interface IUniversityDao<T> extends IBaseDao<University> {
	University getUniversityById(long id);
	List<T> getListedUniversityById(long id);
}
