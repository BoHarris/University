package com.solvd.university.DAO;

import java.util.List;

import com.solvd.university.model.Term;

public interface ITermDao<T> extends IBaseDao<T> {

	List<T> getTermById(long id);
}
