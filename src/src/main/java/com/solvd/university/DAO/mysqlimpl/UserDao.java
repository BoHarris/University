package src.main.java.com.solvd.university.DAO.mysqlimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import src.main.java.com.solvd.university.DAO.IUserDao;
import src.main.java.com.solvd.university.model.User;
import src.main.java.com.solvd.university.model.connection.ConnectionPool;

public class UserDao extends AbstractMySQLDao implements IUserDao<User> {

	private static final Logger log = LogManager.getLogger(UserDao.class);
	private static final String GET_USERS_BY_ID = "Select * from User where id=?";
	private static final String CREATE_USER = "Insert into User"
			+ " ( email, first_name, middle_name, last_name, date_of_birth, home_phone, cell_phone, work_phone,address_id,login_id) VALUES (?, ?, ?, ?, ?,?,?,?,? ,?)";
	private static final String UPDATE_USER = "Update User set last_name = ? where first_name = ?";
	private static final String DELETE_USER = "Delete from User where id = ?";
	private static final String GET_USER_BY_ID = "Select * from User where id=?";

	@Override
	public void createEntity(User entity) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement(CREATE_USER);
			statement.setString(1, entity.getEmail());
			statement.setString(2, entity.getFirstName());
			statement.setString(3, entity.getmiddleName());
			statement.setString(4, entity.getlastName());
			statement.setDate(5, entity.getDateOfBirth());
			statement.setString(6, entity.gethomePhone());
			statement.setString(7, entity.getcellPhone());
			statement.setString(8, entity.getworkPhone());
			statement.setLong(9, entity.getAddressId());
			statement.setLong(10, entity.getLoginId());
			statement.executeUpdate();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		statement.close();
		ConnectionPool.getInstance().releaseConnection(connection);

	}

	@Override
	public User readEntity(long id) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		User user = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement(GET_USERS_BY_ID);
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			resultSetToUser(resultSet);
		} catch (Exception e) {
			log.error(e);
		} finally {
			resultSet.close();
			statement.close();
			ConnectionPool.getInstance().releaseConnection(connection);
		}
		return user;
	}

	public User resultSetToUser(ResultSet resultSet) {
		User user = new User();

		try {
			user.setFirstName(resultSet.getString("first_name"));
			user.setMiddleName(resultSet.getString("middle_name"));
			user.setlastName(resultSet.getString("last_name"));
			user.setDateOfBirth(resultSet.getDate("date_of_birth"));
			user.sethomePhone(resultSet.getString("home_phone"));
			user.setcellPhone(resultSet.getString("cell_phone"));
			user.setworkPhone(resultSet.getString("work_phone"));

		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		return user;
	}

	@Override
	public void updateEntity(User entity) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement(UPDATE_USER);
			statement.setString(1, entity.getcellPhone());
			statement.setString(2, entity.getlastName());
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
			statement = connection.prepareStatement(DELETE_USER);
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
	public List<User> getUserById(long id) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		List<User> users = new ArrayList<>();
		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement(GET_USER_BY_ID);
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getLong("id"));
				user.setFirstName(resultSet.getString("first_name"));
				user.setlastName(resultSet.getString("last_name"));
				users.add(user);

			}
			log.info(users);
		} catch (Exception e) {
			log.error(e);
		} finally {
			resultSet.close();
			statement.close();
			ConnectionPool.getInstance().releaseConnection(connection);
		}
		return users;

	}

}
