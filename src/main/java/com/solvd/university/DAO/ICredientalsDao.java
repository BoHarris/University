package com.solvd.university.DAO;

import java.util.List;

import com.solvd.university.model.Credientals;

public interface ICredientalsDao<T> extends IBaseDao<Credientals> {
	List<T> getAllById(Long id);
}
