package com.solvd.university;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.university.model.connection.ConnectionPool;

public class Test {
	private static final Logger log = LogManager.getLogger(Test.class.getName());

	public static void main(String[] args) throws InterruptedException {
		// to do implement in services, STAX, ENUM and connection pool

		ConnectionPool pool = new ConnectionPool();
		pool.getInstance();

		pool.getConnection();

		log.debug(" ");
	}
}
