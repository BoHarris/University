package src.main.java.com.solvd.university.DAO.mysqlimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import src.main.java.com.solvd.university.DAO.ICityDao;
import src.main.java.com.solvd.university.model.address.City;
import src.main.java.com.solvd.university.model.connection.ConnectionPool;

public class CityDao extends AbstractMySQLDao implements ICityDao<City> {

	private static final Logger LOG = LogManager.getLogger(CityDao.class);
	private static final String GET_CITY_BY_ID = "Select * from City where id=?";
	private static final String CREATE_CITY = "Insert into City" + " ( name, zipcode, state_id) VALUES (?,?,?)";
	private static final String UPDATE_CITY = "Update City set zipcode = ? where name = ?";
	private static final String DELETE_CITY = "Delete from Address where id = ?";
	private static final String GET_ALL_CITIES = "Select * from City";
	private Long cityId;

	public Long getCityId() {
		return cityId;
	}

	public Long setCityId(Long cityId) {
		return this.cityId = cityId;
	}

	@Override
	public void createEntity(City entity) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement(CREATE_CITY);
			statement.setString(1, entity.getName());
			statement.setString(2, entity.getZipCode());
			statement.setLong(3, entity.getStateId());
			statement.executeUpdate();
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		statement.close();
		ConnectionPool.getInstance().releaseConnection(connection);

	}

	@Override
	public City readEntity(long id) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		City city = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement(GET_CITY_BY_ID);
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			resultSetToCity(resultSet);
		} catch (Exception e) {
			LOG.error(e);
		} finally {
			resultSet.close();
			statement.close();
			ConnectionPool.getInstance().releaseConnection(connection);
		}
		return city;
	}

	public City resultSetToCity(ResultSet resultSet) {
		City city = new City();

		try {
			while (resultSet.next()) {
				Long id = resultSet.getLong(1);
				String name = resultSet.getString(2);
				String zipCode = resultSet.getString(3);
				Long stateId = resultSet.getLong(4);

				cityId = setCityId(city.setId(id));

				city.setName(name);
				city.setZipCode(zipCode);
				city.setStateId(stateId);

				id = city.getId();
				name = city.getName();
				zipCode = city.getZipCode();
				LOG.debug(id + " " + name + " " + " " + zipCode + " " + stateId);

				return city;
			}

		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}
		return null;
	}

	@Override
	public void updateEntity(City entity) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement(UPDATE_CITY);
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
			statement = connection.prepareStatement(DELETE_CITY);
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
	public List<City> getCities() throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		List<City> cities = new ArrayList<>();
		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement(GET_ALL_CITIES);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				City city = new City();
				city.setId(resultSet.getLong("id"));
				city.setName(resultSet.getString("name"));
				city.setZipCode(resultSet.getString("zipcode"));
				cities.add(city);
			}
			LOG.info(cities);
		} catch (Exception e) {
			LOG.error(e.getMessage());
		} finally {
			resultSet.close();
			statement.close();
			ConnectionPool.getInstance().releaseConnection(connection);
		}
		return cities;

	}

	@Override
	public List<City> getCityById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}