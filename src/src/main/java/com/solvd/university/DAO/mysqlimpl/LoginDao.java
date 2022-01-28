package com.solvd.university.DAO.mysqlimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.university.DAO.ILoginDao;
import com.solvd.university.model.Login;
import com.solvd.university.model.connection.ConnectionPool;
 
public class LoginDao extends AbstractMySQLDao implements ILoginDao<Login> {

	private static final Logger log = LogManager.getLogger(LoginDao.class);
	private static final String GET_LOGIN_BY_ID = "Select * from Login where id=?";
	private static final String CREATE_LOGIN = "Insert into Login" + " ( name,password ) VALUES (?,?)";
	private static final String UPDATE_LOGIN = "Update Login set name = ? where name = ?";
	private static final String DELETE_LOGIN = "Delete from Address where id = ?";
	private static final String GET_ALL_LOGIN = "Select * from Login";
	private Long loginId;

	public Long getLoginId() {
		return loginId;
	}

	public Long setLoginId(Long loginId) {
		return this.loginId = loginId;
	}

	@Override
	public void createEntity(Login entity) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement(CREATE_LOGIN);
			statement.setString(1, entity.getName());
			statement.setString(2, entity.getPassword());
			statement.executeUpdate();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		statement.close();
		ConnectionPool.getInstance().releaseConnection(connection);

	}

	@Override
	public Login readEntity(long id) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Login Login = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement(GET_LOGIN_BY_ID);
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			resultSetToLogin(resultSet);
		} catch (Exception e) {
			log.error(e);
		} finally {
			resultSet.close();
			statement.close();
			ConnectionPool.getInstance().releaseConnection(connection);
		}
		return Login;
	}

	public Login resultSetToLogin(ResultSet resultSet) {
		Login login = new Login();

		try {
			while (resultSet.next()) {
				Long id = resultSet.getLong(1);
				String name = resultSet.getString(2);
				String password = resultSet.getString(3);

				loginId = setLoginId(login.setId(id));

				login.setName(name);
				login.setPassword(password);

				id = login.getId();
				name = login.getName();
				password = login.getPassword();
				log.debug(id + " " + name + " " + " " + password);
				return login;
			}

		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		return null;
	}

	@Override
	public void updateEntity(Login entity) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement(UPDATE_LOGIN);
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
			statement = connection.prepareStatement(DELETE_LOGIN);
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
	public List<Login> getLogins() throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		List<Login> logins = new ArrayList<>();
		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement(GET_ALL_LOGIN);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Login login = new Login();
				login.setId(resultSet.getLong("id"));
				login.setName(resultSet.getString("name"));
				logins.add(login);
			}
			log.info(logins);
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			resultSet.close();
			statement.close();
			ConnectionPool.getInstance().releaseConnection(connection);
		}
		return logins;

	}
}