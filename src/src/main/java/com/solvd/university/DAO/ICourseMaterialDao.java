package src.main.java.com.solvd.university.DAO;

import java.util.List;

import src.main.java.com.solvd.university.model.CourseMaterial;
import src.main.java.com.solvd.university.model.Position;

public interface ICourseMaterialDao<T> extends IBaseDao<T> {


	List<T> getCourseMaterialById(long id);
}
