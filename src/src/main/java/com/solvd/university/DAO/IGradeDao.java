package src.main.java.com.solvd.university.DAO;

import java.util.List;

import src.main.java.com.solvd.university.model.Grade;

public interface IGradeDao<T> extends IBaseDao<T> {

	List<T> getGradeById(long id);
}
