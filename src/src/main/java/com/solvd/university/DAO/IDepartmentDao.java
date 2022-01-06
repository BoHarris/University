package src.main.java.com.solvd.university.DAO;

import java.util.List;

public interface IDepartmentDao<T> extends IBaseDao<T> {

	List<T> getDepartmentById(long id);
}
