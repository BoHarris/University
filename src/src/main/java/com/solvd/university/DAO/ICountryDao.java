package src.main.java.com.solvd.university.DAO;

import java.sql.SQLException;
import java.util.List;

import src.main.java.com.solvd.university.model.address.Country;

public interface ICountryDao<T> extends IBaseDao<T> {
	List<T> getCountries() throws SQLException;

	List<Country> getCountryById(long id) throws SQLException;
}
