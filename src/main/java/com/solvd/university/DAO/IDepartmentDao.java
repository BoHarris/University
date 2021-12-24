package com.solvd.university.DAO;

import java.util.List;

import com.solvd.university.model.Department;

public interface IDepartmentDao<T> extends IBaseDao<Department> {
	Department getDepartmentById();
	List<T> getListedDepartmentById(long id);
}
