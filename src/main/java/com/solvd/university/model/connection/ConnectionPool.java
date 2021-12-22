package com.solvd.university.model.connection;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CopyOnWriteArrayList;

import com.solvd.university.model.connection.CredentialValues;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public  class ConnectionPool {
	
	
	
private static final Logger log = LogManager.getLogger(ConnectionPool.class.getName());
	
	private static ConnectionPool pool;    // Singleton
	private final Properties prop = new Properties();
	private static final MysqlConnectionPoolDataSource ds = new MysqlConnectionPoolDataSource();
	private List<Connection> connections = new CopyOnWriteArrayList<>();

	public ConnectionPool() {}

//Lazy Initialization
	
	public static ConnectionPool getPoolInstance() {
		if (pool == null) {

			synchronized (ConnectionPool.class) {
				if (pool == null) {
					pool = new ConnectionPool();
				}
			}
		}
		return pool;
	}
	
	private void getPropValues(String file) throws IOException {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(file);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException(file + " not found");
            }

            ds.setURL(prop.getProperty("url"));
            ds.setUser(prop.getProperty("user"));
            ds.setPassword(prop.getProperty("password"));
        } catch (Exception e) {
            log.error("Exception :" + e);
        }
    }

	public synchronized Connection getConnection() throws InterruptedException{
		Connection connection = null;
		if (isConnectionAailable()) {
			try {
				Class.forName("com.myswl.jdbc.Driver");
				Connection con = DriverManager.getConnection(url, user, password);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
			
			
			log.debug("pool size= " + connections.size());
			connection = connections.get(0);
			connections.remove(0);
			log.debug("pool size after = " + connections.size());
		}

		return connection;
	}

	public synchronized void releaseConnection(Connection connection) {
		connections.add(connection);
	}

	private boolean isConnectionAailable() {
		if (connections.isEmpty()) {
			try {
				log.debug("connection is empty");
				Thread.sleep(50);
			} catch (InterruptedException e) {
				log.debug(e.getMessage());;
			}
			isConnectionAailable();
		}
		return true;
	}
}
	
}
