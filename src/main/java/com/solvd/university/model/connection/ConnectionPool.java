package com.solvd.university.model.connection;

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
		if (pool.iterator() != null) {
			pool.add((Connection) getInstance());
		}
	}

	public static ConnectionPool getInstance() {
		if (instance == null) {

			synchronized (ConnectionPool.class) {
				instance = new ConnectionPool();

				try {
					InputStream input = new FileInputStream("resources/db.properties");
					Properties prop = new Properties();
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
		Connection c = pool.poll();
		if (c == null && existingConnectionsCount < MAX_POOL_CAPACITY) {
			try {
				Driver driver = null;
				try {
					driver = (Driver) Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				}
				DriverManager.registerDriver(driver);
				existingConnectionsCount++;
				return DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				log.error(e.getMessage());
			}
		}

		return pool.take();
	}

	public void releaseConnection(Connection con) {
		pool.add(con);
	}
}