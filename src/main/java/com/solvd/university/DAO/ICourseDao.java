package com.solvd.university.DAO;

import java.util.List;

import com.solvd.university.model.Course;

public interface ICourseDao<T> extends IBaseDao<Course> {
	List<T> getCourseById(long id);
}
