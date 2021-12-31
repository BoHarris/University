package src.main.java.com.solvd.university.DAO;

import java.util.List;

import src.main.java.com.solvd.university.model.Term;

public interface ITermDao<T> extends IBaseDao<T> {

	List<T> getTermById(long id);
}
