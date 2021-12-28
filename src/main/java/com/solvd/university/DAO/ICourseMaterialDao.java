package com.solvd.university.DAO;

import java.util.List;

import com.solvd.university.model.CourseMaterial;
import com.solvd.university.model.Position;

public interface ICourseMaterialDao<T> extends IBaseDao<T> {


	List<T> getCourseMaterialById(long id);
}
