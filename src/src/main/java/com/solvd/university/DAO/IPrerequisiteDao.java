package com.solvd.university.DAO;

import java.util.List;

public interface IPrerequisiteDao<T> extends IBaseDao<T> {

	List<T> getPrerequisiteById(long id);

}
