package src.main.java.com.solvd.university.DAO;

import java.util.List;

public interface IUndergraduateDao<T> extends IBaseDao<T> {

	List<T> getUndergraduateById(long id);
}
