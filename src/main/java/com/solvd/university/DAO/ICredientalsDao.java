package com.solvd.university.DAO;

import java.util.List;

import com.solvd.university.model.Credientals;
import com.solvd.university.model.Position;

public interface ICredientalsDao<T> extends IBaseDao<T> {

	List<T> getCredientalsById(long id);
}
