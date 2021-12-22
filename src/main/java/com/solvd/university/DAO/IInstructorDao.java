package com.solvd.university.DAO;

import java.util.List;

import com.solvd.university.model.Instructor;

public interface IInstructorDao<T> extends IBaseDao<Instructor> {
	List<T> getAllById(Long id);
}
