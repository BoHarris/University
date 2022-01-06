package src.main.java.com.solvd.university.DAO;

import java.sql.SQLException;
import java.util.List;

public interface IContinentDao<T> extends IBaseDao<T> {
	List<T> getListOfContinentById(long id) throws SQLException;

}
