package com.solvd.university;

import java.sql.Date;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.university.DAO.mysqlimpl.AddressDao;
import com.solvd.university.DAO.mysqlimpl.CityDao;
import com.solvd.university.DAO.mysqlimpl.ContinentDao;
import com.solvd.university.DAO.mysqlimpl.CountryDao;
import com.solvd.university.DAO.mysqlimpl.StateDao;
import com.solvd.university.model.address.Address;
import com.solvd.university.model.address.City;
import com.solvd.university.model.address.Continent;
import com.solvd.university.model.address.Country;
import com.solvd.university.model.address.State;

public class Test {
	private static final Logger log = LogManager.getLogger(Test.class.getName());
	private static final String FILE_NAME = "resources/User.xml";

	public static void main(String[] args) throws InterruptedException {
		Date date = new Date(1220227200L * 1000);

		ContinentDao continentDao = new ContinentDao();
		Continent continent = new Continent("North America");

		try {
			continentDao.createEntity(continent);
		} catch (SQLException e) {
			log.debug(e.getMessage());
		}

		CountryDao countryDao = new CountryDao();
		Country country = new Country("United States", "N/A");

		StateDao stateDao = new StateDao();
		State state = new State("Florida", "32084");
		try {
			stateDao.createEntity(state);
		} catch (SQLException e) {
			log.debug(e.getMessage());
		}

		CityDao cityDao = new CityDao();
		City city = new City("Saint Augustine", "32084");

		try {
			cityDao.createEntity(city);
		} catch (SQLException e) {
			log.debug(e.getMessage());
		}

		AddressDao addressDao = new AddressDao();
		Address address = new Address(1, "Main Street");

		try {
			addressDao.createEntity(address);
		} catch (SQLException e) {
			log.debug(e.getMessage());
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