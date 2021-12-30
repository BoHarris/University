package com.solvd.university;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.io.StringWriter;
import java.sql.Date;
import java.sql.SQLException;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.university.DAO.mysqlimpl.UserDao;
import com.solvd.university.model.User;
import com.solvd.university.model.connection.ConnectionPool;

public class Test {
	private static final Logger log = LogManager.getLogger(Test.class.getName());
	private static final String FILE_NAME = "resources/User.xml";

	public static void main(String[] args) throws InterruptedException {
		Date date = new Date(1220227200L * 1000);
		User user = new User(null, FILE_NAME, FILE_NAME, FILE_NAME, FILE_NAME, date, FILE_NAME, FILE_NAME, FILE_NAME, 1,
				1, null, null);
		UserDao userDao = new UserDao();
		try {
			userDao.createEntity(user);
		} catch (SQLException e) {
			log.error(e.getMessage());
		}

	}
}
/*
 * 
 * try {
 * 
 * log.debug(transformXML(4, (new StAXHandler()).processXMLFile(new
 * File(FILE_NAME)).toString())); } catch (FileNotFoundException e) {
 * log.error("FileNotFoundException" + e.getMessage()); } catch
 * (XMLStreamException e) { log.error("XMLStreamException: " + e.getMessage());
 * } catch (FactoryConfigurationError e) {
 * log.error("FactoryConfigurationError: " + e.getMessage()); } catch
 * (TransformerException e) { log.error("Transformer Error: " + e.getMessage());
 * } }
 * 
 * public static String transformXML(int indentation, String rawXML) throws
 * TransformerException { TransformerFactory transformerFactory =
 * TransformerFactory.newInstance();
 * transformerFactory.setAttribute("indent-number", indentation); Transformer
 * transformer = transformerFactory.newTransformer();
 * transformer.setOutputProperty(OutputKeys.INDENT, "yes"); StreamResult
 * streamResult = new StreamResult(new StringWriter());
 * transformer.transform(new StreamSource(new StringReader(rawXML)),
 * streamResult); return streamResult.getWriter().toString(); } }
 * 
 */