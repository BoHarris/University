package com.solvd.university.model.connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CredentialValues {

	public CredentialValues() {
	}

	private static final Logger log = LogManager.getLogger(CredentialValues.class.getName());
	private final Properties prop = new Properties();
	private String propFileName;
	private InputStream inputStream;
	private String url;
	private String schema;
	private String name;
	private String password;

	public String getUrl() {
		return url;
	}

	public String getSchema() {
		return schema;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public void getPropValues(String value) throws IOException {
		try {
			propFileName = value;

			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException(propFileName + " not found");
			}

			url = prop.getProperty("url");
			schema = prop.getProperty("schema");
			name = prop.getProperty("name");
			password = prop.getProperty("password");
		} catch (Exception e) {
			log.error("Exception:  " + e);
		}
	}
}