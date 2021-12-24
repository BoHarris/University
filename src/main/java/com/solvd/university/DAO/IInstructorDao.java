package com.solvd.university.DAO;

import java.util.List;

import com.solvd.university.model.Instructor;

public interface IInstructorDao<T> extends IBaseDao<Instructor> {
	Instructor getInstructorById(long id);
	List<T> getListedInstructorById(long id);
}
