package com.solvd.university.DAO;

public interface IBaseDao<T> {
	void createEntity(T entity);
	void readEntity(long id);
	T updateEntity(T entity);
	void deleteEntinty();
}
