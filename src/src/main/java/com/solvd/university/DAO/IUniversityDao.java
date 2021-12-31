package src.main.java.com.solvd.university.DAO;

import java.util.List;

import src.main.java.com.solvd.university.model.University;

public interface IUniversityDao<T> extends IBaseDao<T> {
	List<T> getUniversityById(long id);
}
