package src.main.java.com.solvd.university.DAO;

import java.util.List;

public interface ITermDao<T> extends IBaseDao<T> {

	List<T> getTermById(long id);
}
