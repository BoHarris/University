package src.main.java.com.solvd.university.DAO.mysqlimpl;

import java.sql.Connection;
import java.sql.Date;
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
	private static final String GET_USER_BY_ID = "Select * from User where id=?";
	private static final String CREATE_USER = "Insert into User"
			+ " ( email, first_name, middle_name, last_name, date_of_birth, home_phone, cell_phone, work_phone,address_id,login_id) VALUES (?, ?, ?, ?, ?,?,?,?,? ,?)";
	private static final String UPDATE_USER = "Update User set last_name = ? where first_name = ?";
	private static final String DELETE_USER = "Delete from User where id = ?";

	private Long userId;

	public Long getUserId() {
		return userId;
	}

	public Long setUserId(Long userId) {
		return this.userId = userId;
	}

	@Override
	public void createEntity(User entity) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement(CREATE_USER);
			statement.setString(1, entity.getEmail());
			statement.setString(2, entity.getFirstName());
			statement.setString(3, entity.getMiddleName());
			statement.setString(4, entity.getLastName());
			statement.setDate(5, entity.getDateOfBirth());
			statement.setString(6, entity.getHomePhone());
			statement.setString(7, entity.getCellPhone());
			statement.setString(8, entity.getWorkPhone());
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
			statement = connection.prepareStatement(GET_USER_BY_ID);
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

			while (resultSet.next()) {
				Long id = resultSet.getLong(1);
				String email = resultSet.getString(2);
				String firstName = resultSet.getString(3);
				String middleName = resultSet.getString(4);
				String lastName = resultSet.getString(5);
				Date dateOfBirth = resultSet.getDate(6);
				String homePhone = resultSet.getString(7);
				String cellPhone = resultSet.getString(8);
				String workPhone = resultSet.getString(9);
				Long addressId = resultSet.getLong(10);
				Long loginId = resultSet.getLong(11);

				userId = setUserId(user.setId(id));
				

				user.setEmail(email);
				user.setFirstName(firstName);
				user.setMiddleName(middleName);
				user.setLastName(lastName);
				user.setDateOfBirth(dateOfBirth);
				user.setHomePhone(homePhone);
				user.setCellPhone(cellPhone);
				user.setWorkPhone(workPhone);
				user.setAddressId(addressId);
				user.setLoginId(loginId);

				id = user.getId();
				email = user.getEmail();
				firstName = user.getFirstName();
				middleName = user.getMiddleName();
				lastName = user.getLastName();
				dateOfBirth = user.getDateOfBirth();
				homePhone = user.getHomePhone();
				cellPhone = user.getCellPhone();
				workPhone = user.getWorkPhone();
				addressId = user.getAddressId();
				loginId = user.getLoginId();

				log.debug(id + " " + firstName + " " + " " + middleName + " " + " " + lastName + " " + " " + dateOfBirth
						+ " " + " " + email + " " + " " + homePhone + " " + " " + cellPhone + " " + " " + workPhone);
				return user;
			}

		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		return null;
	}

	@Override
	public void updateEntity(User entity) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement(UPDATE_USER);
			statement.setString(1, entity.getCellPhone());
			statement.setString(2, entity.getLastName());
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
				user.setLastName(resultSet.getString("last_name"));
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
