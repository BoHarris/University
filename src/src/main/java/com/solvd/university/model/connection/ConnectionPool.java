package src.main.java.com.solvd.university.model.connection;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.jdbc.Driver;

public class ConnectionPool {

	private static final Logger log = LogManager.getLogger(ConnectionPool.class.getName());

	private static ConnectionPool instance;
	private static LinkedBlockingQueue<Connection> pool;
	private static final int MAX_POOL_CAPACITY = 10;
	private static int existingConnectionsCount = 0;
	private static String url;
	private static String user;
	private static String password;

	public ConnectionPool() {
	}

	public static ConnectionPool getInstance() {
		if (instance == null) {

			synchronized (ConnectionPool.class) {
				instance = new ConnectionPool();
				pool = new LinkedBlockingQueue<>();
				 log.info("Creating Connection Pool");


				try {
					InputStream input = new FileInputStream("resources/db.properties");
					Properties prop = new Properties();
					log.info("Retrieving creditntals.");
					prop.load(input);
					url = prop.getProperty("url");
					user = prop.getProperty("username");
					password = prop.getProperty("password");
				} catch (Exception e) {
					log.error(e.getMessage());
				}
			}

		}
		return instance;
	}

	public Connection getConnection() throws InterruptedException {
		if (existingConnectionsCount < MAX_POOL_CAPACITY) {
			log.info("No connections pooled. Creating connection.");

			try {
				existingConnectionsCount++;
				Class.forName("com.mysql.cj.jdbc.Driver");
				return DriverManager.getConnection(url, user, password);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}

		log.info("Retrieving  connection from pool.");
		Connection con = pool.take();
		log.info("Connection successfully retrieved from pool.");

		return con;
	}

	public void releaseConnection(Connection con) {
		if (pool.add(con) && pool.size() <= MAX_POOL_CAPACITY)
			log.info("Connection successfully pooled.");
		else
			log.error("Connection pooling failed. An external connection may have been "
					+ "-or is currently attempting to be- added to the pool.");
	}
}
