package src.main.java.com.solvd.university.DAO.mysqlimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import src.main.java.com.solvd.university.DAO.IContinentDao;
import src.main.java.com.solvd.university.model.address.Continent;
import src.main.java.com.solvd.university.model.connection.ConnectionPool;

public class ContinentDao extends AbstractMySQLDao implements IContinentDao<Continent> {

	private static final Logger log = LogManager.getLogger(ContinentDao.class);
	private static final String GET_CONTINENT_BY_ID = "Select * from Continent where id=?";
	private static final String CREATE_CONTINENT = "Insert into Continent" + " (id, name) VALUES ( ?, ?)";
	private static final String UPDATE_CONTINENT = "Update Continent set name = ? where id = ?";
	private static final String DELETE_CONTINENT = "Delete from Address where id = ?";

	@Override
	public void createEntity(Continent entity) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement(CREATE_CONTINENT);
			statement.setLong(1, entity.getId());
			statement.setString(2, entity.getName());
			statement.executeUpdate();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		statement.close();
		ConnectionPool.getInstance().releaseConnection(connection);

	}

	@Override
	public Continent readEntity(long id) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Continent Continent = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement(GET_CONTINENT_BY_ID);
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			resultSetToContinent(resultSet);
		} catch (Exception e) {
			log.error(e);
		} finally {
			resultSet.close();
			statement.close();
			ConnectionPool.getInstance().releaseConnection(connection);
		}
		return Continent;
	}

	public Continent resultSetToContinent(ResultSet resultSet) {
		Continent continent = new Continent();

		try {
			while (resultSet.next()) {
				Long id = resultSet.getLong(1);
				String name = resultSet.getString(2);

				continent.setId(resultSet.getLong(1));

				continent.setName(name);
				log.debug(id + " " + name);

				return continent;
			}

		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		return null;
	}

	@Override
	public void updateEntity(Continent entity) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement(UPDATE_CONTINENT);
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
			statement = connection.prepareStatement(DELETE_CONTINENT);
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
	public List<Continent> getListOfContinentById(long id) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		List<Continent> continents = new ArrayList<>();
		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement(GET_CONTINENT_BY_ID);
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Continent continent = new Continent();
				continent.setId(resultSet.getLong("id"));
				continent.setName(resultSet.getString("name"));

			}
			log.info(continents);
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			resultSet.close();
			statement.close();
			ConnectionPool.getInstance().releaseConnection(connection);
		}
		return continents;

	}

}
