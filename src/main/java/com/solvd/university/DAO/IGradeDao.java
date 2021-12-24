package com.solvd.university.DAO;

import java.util.List;

import com.solvd.university.model.Grade;

public interface IGradeDao<T> extends IBaseDao<Grade> {

	Grade getGradeById(long id);
	List<T> getListedGradeById(long id);
}
