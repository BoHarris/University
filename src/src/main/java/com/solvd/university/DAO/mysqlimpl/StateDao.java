package com.solvd.university.DAO.mysqlimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.university.DAO.IStateDao;
import com.solvd.university.model.address.State;
import com.solvd.university.model.connection.ConnectionPool;

public class StateDao extends AbstractMySQLDao implements IStateDao<State> {

	private static final Logger LOG = LogManager.getLogger(StateDao.class);
	private static final String GET_STATE_BY_ID = "Select * from State where id=?";
	private static final String CREATE_STATE = "Insert into State" + " ( name,country_id ) VALUES (?,?)";
	private static final String UPDATE_STATE = "Update State set name = ? where name = ?";
	private static final String DELETE_STATE = "Delete from Address where id = ?";
	private static final String GET_ALL_STATES = "Select * from State";
	private Long stateId;

	public Long getStateId() {
		return stateId;
	}

	public Long setStateId(Long stateId) {
		return this.stateId = stateId;
	}

	@Override
	public void createEntity(State entity) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement(CREATE_STATE);
			statement.setString(1, entity.getName());
			statement.setLong(2, entity.getCountryId());
			statement.executeUpdate();
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		statement.close();
		ConnectionPool.getInstance().releaseConnection(connection);

	}

	@Override
	public State readEntity(long id) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		State State = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement(GET_STATE_BY_ID);
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			resultSetToState(resultSet);
		} catch (Exception e) {
			LOG.error(e);
		} finally {
			resultSet.close();
			statement.close();
			ConnectionPool.getInstance().releaseConnection(connection);
		}
		return State;
	}

	public State resultSetToState(ResultSet resultSet) {
		State state = new State();

		try {
			while (resultSet.next()) {
				Long id = resultSet.getLong(1);
				String name = resultSet.getString(2);
				Long countryId = resultSet.getLong(3);

				stateId = setStateId(state.setId(id));

				state.setName(name);
				state.setCountryId(countryId);

				id = state.getId();
				name = state.getName();
				LOG.debug(id + " " + name + " " + " " + stateId);
				return state;
			}

		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}
		return null;
	}

	@Override
	public void updateEntity(State entity) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement(UPDATE_STATE);
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
			statement = connection.prepareStatement(DELETE_STATE);
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
	public List<State> getStates() throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		List<State> states = new ArrayList<>();
		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement(GET_ALL_STATES);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				State state = new State();
				state.setId(resultSet.getLong("id"));
				state.setName(resultSet.getString("name"));
				state.setCountryId(resultSet.getLong("countryId"));
				states.add(state);
			}
			LOG.info(states);
		} catch (Exception e) {
			LOG.error(e.getMessage());
		} finally {
			resultSet.close();
			statement.close();
			ConnectionPool.getInstance().releaseConnection(connection);
		}
		return states;

	}

	@Override
	public List<State> getStateById(long id) {
		// TODO Auto-generated method stub
		return null;
	}
}