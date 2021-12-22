package com.solvd.university.DAO;

import java.util.List;

import com.solvd.university.model.Undergraduate;

public interface IUndergraduateDao<T> extends IBaseDao<Undergraduate>  {
	List<T> getAllById(Long id);
}
