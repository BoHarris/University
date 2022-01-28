package com.solvd.university.DAO;

import java.util.List;

public interface ICourseDao<T> extends IBaseDao<T> {

	List<T> getCourseById(long id);
}
