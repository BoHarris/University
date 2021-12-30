package com.solvd.university.DAO.mysqlimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.university.DAO.ICountryDao;
import com.solvd.university.model.address.Country;
import com.solvd.university.model.connection.ConnectionPool;

public class CountryDao extends AbstractMySQLDao implements ICountryDao<Country> {

	private static final Logger log = LogManager.getLogger(CountryDao.class);
	private static final String GET_COUNTRY_BY_ID = "Select * from Country where id=?";
	private static final String CREATE_COUNTRY = "Insert into Country" + " ( name, country_code) VALUES (?,?)";
	private static final String UPDATE_COUNTRY = "Update Country set zipcode = ? where name = ?";
	private static final String DELETE_COUNTRY = "Delete from Address where id = ?";

	@Override
	public void createEntity(Country entity) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement(CREATE_COUNTRY);
			statement.setString(1, entity.getName());
			statement.setString(2, entity.getCountryCode());
			statement.executeUpdate();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		statement.close();
		ConnectionPool.getInstance().releaseConnection(connection);

	}

	@Override
	public Country readEntity(long id) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Country Country = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement(GET_COUNTRY_BY_ID);
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			resultSetToCountry(resultSet);
		} catch (Exception e) {
			log.error(e);
		} finally {
			resultSet.close();
			statement.close();
			ConnectionPool.getInstance().releaseConnection(connection);
		}
		return Country;
	}

	public Country resultSetToCountry(ResultSet resultSet) {
		Country Country = new Country();

		try {
			Country.setName(resultSet.getString("name"));
			Country.setCountryCode(resultSet.getString("country_code"));

		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		return Country;
	}

	@Override
	public void updateEntity(Country entity) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement(UPDATE_COUNTRY);
			statement.setString(1, entity.getName());
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
			statement = connection.prepareStatement(DELETE_COUNTRY);
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
	public List<Country> getCountryById(long id) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		List<Country> cities = new ArrayList<>();
		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement(GET_COUNTRY_BY_ID);
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Country Country = new Country();
				Country.setId(resultSet.getLong("id"));
				Country.setName(resultSet.getString("name"));
				Country.setCountryCode(resultSet.getString("country_code"));

			}
			log.info(cities);
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			resultSet.close();
			statement.close();
			ConnectionPool.getInstance().releaseConnection(connection);
		}
		return cities;

	}
}