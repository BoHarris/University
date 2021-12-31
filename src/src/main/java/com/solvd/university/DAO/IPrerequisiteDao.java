package src.main.java.com.solvd.university.DAO;

import java.util.List;

import src.main.java.com.solvd.university.model.Prerequisite;

public interface IPrerequisiteDao<T> extends IBaseDao<T> {

	List<T> getPrerequisiteById(long id);

	
}
