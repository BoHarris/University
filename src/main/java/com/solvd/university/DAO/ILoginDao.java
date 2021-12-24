package com.solvd.university.DAO;

import java.util.List;

import com.solvd.university.model.Login;

public interface ILoginDao<T> extends IBaseDao<Login> {
	Login getLoginById(long id);
	List<T> getListedLoginById(long id);
}
