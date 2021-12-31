package src.main.java.com.solvd.university.DAO;

import java.util.List;

import src.main.java.com.solvd.university.model.Undergraduate;

public interface IUndergraduateDao<T> extends IBaseDao<T> {

	List<T> getUndergraduateById(long id);
}
