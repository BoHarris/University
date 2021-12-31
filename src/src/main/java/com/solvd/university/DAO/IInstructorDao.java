package src.main.java.com.solvd.university.DAO;

import java.util.List;

import src.main.java.com.solvd.university.model.Instructor;

public interface IInstructorDao<T> extends IBaseDao<T> {

	List<T> getInstructorById(long id);
}
