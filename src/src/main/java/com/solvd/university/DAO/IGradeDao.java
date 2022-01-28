package com.solvd.university.DAO;

import java.util.List;

public interface IGradeDao<T> extends IBaseDao<T> {

	List<T> getGradeById(long id);
}
