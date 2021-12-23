package com.solvd.university;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.university.model.connection.ConnectionPool;

public class Test {
	private static final Logger log = LogManager.getLogger(Test.class.getName());

	public static void main(String[] args) throws InterruptedException {
		//to do implement in services, STAX and connection pool
		
		InputStream input = null;
		try {
			input = new FileInputStream("resources/db.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(input);

		log.debug("works");
	}
}
