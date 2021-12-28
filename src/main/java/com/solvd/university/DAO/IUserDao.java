package com.solvd.university.DAO;



import java.util.List;

import com.solvd.university.model.User;

public interface IUserDao<T> extends IBaseDao<T> {

	List<T> getUserById(long id);
}
