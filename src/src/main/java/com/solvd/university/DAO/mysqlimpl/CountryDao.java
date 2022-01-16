package src.main.java.com.solvd.university.DAO.mysqlimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import src.main.java.com.solvd.university.DAO.ICountryDao;
import src.main.java.com.solvd.university.model.address.Continent;
import src.main.java.com.solvd.university.model.address.Country;
import src.main.java.com.solvd.university.model.connection.ConnectionPool;

public class CountryDao extends AbstractMySQLDao implements ICountryDao<Country> {

	private static final Logger LOG = LogManager.getLogger(CountryDao.class);
	private static final String GET_COUNTRY_BY_ID = "Select * from Country where id=?";
	private static final String CREATE_COUNTRY = "Insert into Country"
			+ " ( name, country_code, continent_id) VALUES (?,?,?)";
	private static final String UPDATE_COUNTRY = "Update Country set zipcode = ? where name = ?";
	private static final String DELETE_COUNTRY = "Delete from Address where id = ?";
	private static final String GET_ALL_COUNTRIES = "Select * from Country";
	private Long countryId;

	public Long getCountryId() {
		return countryId;
	}

	public Long setCountryId(Long countryId) {
		return this.countryId = countryId;
	}

	@Override
	public void createEntity(Country entity) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement(CREATE_COUNTRY);
			statement.setString(1, entity.getName());
			statement.setString(2, entity.getCountryCode());
			statement.setLong(3, entity.getContinentId());
			statement.executeUpdate();
		} catch (Exception e) {
			LOG.error(e.getMessage());
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

		} catch (

		Exception e) {
			LOG.error(e);
		} finally {
			resultSet.close();
			statement.close();
			ConnectionPool.getInstance().releaseConnection(connection);
		}
		return Country;
	}

	public Country resultSetToCountry(ResultSet resultSet) {
		Country country = new Country();

		try {
			while (resultSet.next()) {

				Long id = resultSet.getLong(1);
				String name = resultSet.getString(2);
				String countrycode = resultSet.getString(3);
				Long continentId = resultSet.getLong(4);
				countryId = setCountryId(country.setId(id));
				country.setName(name);
				country.setCountryCode(countrycode);
				country.setContinentId(continentId);

				id = country.getId();
				name = country.getName();
				countrycode = country.getCountryCode();
				LOG.debug(id + " " + name + " " + " " + countrycode + " " + continentId);

				return country;
			}

		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}
		return null;
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
			LOG.error(e);
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
			LOG.error(e);
		} finally {
			statement.close();
			ConnectionPool.getInstance().releaseConnection(connection);
		}

	}

	@Override
	public List<Country> getCountries() throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		List<Country> countries = new ArrayList<>();
		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement(GET_ALL_COUNTRIES);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Country country = new Country();
				country.setId(resultSet.getLong("id"));
				country.setName(resultSet.getString("name"));
				country.setCountryCode(resultSet.getString("country_code"));
				countries.add(country);
			}
			LOG.info(countries);
		} catch (Exception e) {
			LOG.error(e.getMessage());
		} finally {
			resultSet.close();
			statement.close();
			ConnectionPool.getInstance().releaseConnection(connection);
		}
		return countries;

	}

	@Override
	public List<Country> getCountryById(long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}