package com.solvd.university.DAO;

import java.util.List;

import com.solvd.university.model.CourseMaterial;
import com.solvd.university.model.Position;

public interface ICourseMaterialDao<T> extends IBaseDao<CourseMaterial> {
	CourseMaterial getCourseMaterialById(long id);

	List<T> getListedCourseMaterialById(long id);
}
