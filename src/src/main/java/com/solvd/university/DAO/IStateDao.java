package src.main.java.com.solvd.university.DAO;

import java.sql.SQLException;
import java.util.List;

public interface IStateDao<T> extends IBaseDao<T> {
	List<T> getStateById(long id) throws SQLException;
}
