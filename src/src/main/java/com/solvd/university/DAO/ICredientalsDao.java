package com.solvd.university.DAO;

import java.util.List;

public interface ICredientalsDao<T> extends IBaseDao<T> {

	List<T> getCredientalsById(long id);
}
