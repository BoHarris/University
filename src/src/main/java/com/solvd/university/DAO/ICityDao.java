package src.main.java.com.solvd.university.DAO;

import java.sql.SQLException;
import java.util.List;

public interface ICityDao<T> extends IBaseDao<T> {

	List<T> getCityById(long id) throws SQLException;
}
