package src.main.java.com.solvd.university.DAO;

import java.util.List;

import src.main.java.com.solvd.university.model.Credientals;
import src.main.java.com.solvd.university.model.Position;

public interface ICredientalsDao<T> extends IBaseDao<T> {

	List<T> getCredientalsById(long id);
}
