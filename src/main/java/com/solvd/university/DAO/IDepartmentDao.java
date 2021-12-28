package com.solvd.university.DAO;

import java.util.List;

import com.solvd.university.model.Department;

public interface IDepartmentDao<T> extends IBaseDao<T> {

	List<T> getDepartmentById(long id);
}
