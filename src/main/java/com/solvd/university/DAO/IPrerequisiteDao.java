package com.solvd.university.DAO;

import com.solvd.university.model.Prerequisite;

public interface IPrerequisiteDao<T> extends IBaseDao<Prerequisite> {
	Prerequisite getPrerequisiteById(long id);
}
