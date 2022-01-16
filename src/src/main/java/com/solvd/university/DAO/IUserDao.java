package src.main.java.com.solvd.university.DAO;

import java.sql.SQLException;
import java.util.List;

import src.main.java.com.solvd.university.model.User;

public interface IUserDao<T> extends IBaseDao<T> {

	List<T> getUsers() throws SQLException;

	List<User> getUserById(long id) throws SQLException;
}
