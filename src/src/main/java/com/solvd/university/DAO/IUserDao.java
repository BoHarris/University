package src.main.java.com.solvd.university.DAO;

import java.sql.SQLException;
import java.util.List;

import src.main.java.com.solvd.university.model.User;

public interface IUserDao<T> extends IBaseDao<T> {

	List<T> getUserById(long id) throws SQLException;
}