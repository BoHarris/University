package com.solvd.university.DAO;

import java.util.List;

import com.solvd.university.model.CourseMaterial;

public interface ICourseMaterialDao<T> extends IBaseDao<CourseMaterial> {
	List<T> getAllById(Long id);
}
