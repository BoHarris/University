package src.main.java.com.solvd.university.DAO;

import java.util.List;

import src.main.java.com.solvd.university.model.Position;

public interface IPositionDao<T> extends IBaseDao<T> {
	List<T> getPositionById(long id);
}
