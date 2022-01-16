package src.main.java.com.solvd.university.DAO;

import java.sql.SQLException;
import java.util.List;

import src.main.java.com.solvd.university.model.address.Address;

public interface IAddressDao<T> extends IBaseDao<T> {
	List<T> getAddresses() throws SQLException;

	List<Address> getAddressById(Long id) throws SQLException;
}
