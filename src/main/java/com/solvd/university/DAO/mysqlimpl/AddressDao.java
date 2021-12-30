package com.solvd.university.DAO.mysqlimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.university.DAO.IAddressDao;
import com.solvd.university.model.User;
import com.solvd.university.model.address.Address;
import com.solvd.university.model.connection.ConnectionPool;

public class AddressDao extends AbstractMySQLDao implements IAddressDao<Address> {
	private static final Logger log = LogManager.getLogger(UserDao.class);
	private static final String GET_USERS_BY_ID = "Select * from Address where id=?";
	private static final String CREATE_ADDRESS = "Insert into Address"
			+ " ( building_number, street_name, city_id) VALUES (?,?,?)";
	private static final String UPDATE_ADDRESS = "Update Address set building_number = ? where street_name = ?";
	private static final String DELETE_ADDRESS = "Delete from Address where id = ?";
	private static final String GET_Address_BY_ID = "Select * from Address where id=?";

	@Override
	public void createEntity(Address entity) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement(CREATE_ADDRESS);
			statement.setInt(1, entity.getBuildingNumber());
			statement.setString(2, entity.getStreetName());
			statement.setLong(3, entity.getCityId());
			statement.executeUpdate();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		statement.close();
		ConnectionPool.getInstance().releaseConnection(connection);

	}

	@Override
	public Address readEntity(long id) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Address address = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement(GET_Address_BY_ID);
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			resultSetToAddress(resultSet);
		} catch (Exception e) {
			log.error(e);
		} finally {
			resultSet.close();
			statement.close();
			ConnectionPool.getInstance().releaseConnection(connection);
		}
		return address;
	}

	public Address resultSetToAddress(ResultSet resultSet) {
		Address address = new Address();

		try {
			address.setBuildingNumber(resultSet.getInt("build_number"));
			address.setStreetName(resultSet.getString("street_name"));

		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		return address;
	}

	@Override
	public void updateEntity(Address entity) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement(UPDATE_ADDRESS);
			statement.setString(1, entity.getStreetName());
			statement.executeUpdate();

		} catch (Exception e) {
			log.error(e);
		} finally {
			statement.close();
			ConnectionPool.getInstance().releaseConnection(connection);
		}

	}

	@Override
	public void deleteEntinty(long id) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement(DELETE_ADDRESS);
			statement.setLong(1, id);
			statement.executeUpdate();

		} catch (Exception e) {
			log.error(e);
		} finally {
			statement.close();
			ConnectionPool.getInstance().releaseConnection(connection);
		}

	}

	@Override
	public List<Address> getAddressById(long id) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		List<Address> addresses = new ArrayList<>();
		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement(GET_Address_BY_ID);
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Address address = new Address();
				address.setId(resultSet.getLong("id"));
				address.setBuildingNumber(resultSet.getInt("build_number"));
				address.setStreetName(resultSet.getString("street_name"));
				addresses.add(address);

			}
			log.info(addresses);
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			resultSet.close();
			statement.close();
			ConnectionPool.getInstance().releaseConnection(connection);
		}
		return addresses;

	}

}
