package com.solvd.university.DAO;

import java.util.List;

public interface IInstructorDao<T> extends IBaseDao<T> {

	List<T> getInstructorById(long id);
}
