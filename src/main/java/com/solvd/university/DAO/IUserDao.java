package com.solvd.university.DAO;

import com.solvd.university.model.User;

public interface IUserDao<T> extends IBaseDao<User> {

	User getUserById(long id);
}
