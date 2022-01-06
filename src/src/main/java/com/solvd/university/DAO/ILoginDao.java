package src.main.java.com.solvd.university.DAO;

import java.sql.SQLException;
import java.util.List;

public interface ILoginDao<T> extends IBaseDao<T> {
	List<T> getLoginById(long id) throws SQLException;
}
