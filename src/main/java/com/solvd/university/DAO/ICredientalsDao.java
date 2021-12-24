package com.solvd.university.DAO;

import java.util.List;

import com.solvd.university.model.Credientals;
import com.solvd.university.model.Position;

public interface ICredientalsDao<T> extends IBaseDao<Credientals> {
	Credientals getCreditntalsById(long id);

	List<T> getListedCredientalsById(long id);
}
