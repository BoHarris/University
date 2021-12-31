package src.main.java.com.solvd.university.DAO;

import java.sql.SQLException;
import java.util.List;

import src.main.java.com.solvd.university.model.address.Continent;

public interface IContinentDao<T> extends IBaseDao<T> {
	List<T> getListOfContinentById(long id) throws SQLException;

	
}
