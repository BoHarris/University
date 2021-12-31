package src.main.java.com.solvd.university.DAO;

import java.util.List;

import src.main.java.com.solvd.university.model.Course;

public interface ICourseDao<T> extends IBaseDao<T> {


	List<T> getCourseById(long id);
}
