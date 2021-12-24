package com.solvd.university.DAO;

import java.util.List;

import com.solvd.university.model.Undergraduate;

public interface IUndergraduateDao<T> extends IBaseDao<Undergraduate> {
	Undergraduate getListedUndergraduateById(long id);

	List<T> getUndergraduateById(long id);
}
