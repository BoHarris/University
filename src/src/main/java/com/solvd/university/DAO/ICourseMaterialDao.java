package com.solvd.university.DAO;

import java.util.List;

public interface ICourseMaterialDao<T> extends IBaseDao<T> {

	List<T> getCourseMaterialById(long id);
}
