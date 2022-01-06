package src.main.java.com.solvd.university.DAO;

import java.sql.SQLException;
import java.util.List;

public interface ICountryDao<T> extends IBaseDao<T> {
	List<T> getCountryById(long id) throws SQLException;
}
