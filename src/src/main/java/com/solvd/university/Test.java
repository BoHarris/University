package src.main.java.com.solvd.university;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Value;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.solvd.university.test.TestNG;

import src.main.java.com.solvd.university.DAO.mysqlimpl.AddressDao;
import src.main.java.com.solvd.university.DAO.mysqlimpl.CityDao;
import src.main.java.com.solvd.university.DAO.mysqlimpl.ContinentDao;
import src.main.java.com.solvd.university.DAO.mysqlimpl.CountryDao;
import src.main.java.com.solvd.university.DAO.mysqlimpl.LoginDao;
import src.main.java.com.solvd.university.DAO.mysqlimpl.StateDao;
import src.main.java.com.solvd.university.DAO.mysqlimpl.UserDao;
import src.main.java.com.solvd.university.model.Login;
import src.main.java.com.solvd.university.model.User;
import src.main.java.com.solvd.university.model.address.Address;
import src.main.java.com.solvd.university.model.address.City;
import src.main.java.com.solvd.university.model.address.Continent;
import src.main.java.com.solvd.university.model.address.Country;
import src.main.java.com.solvd.university.model.address.State;

public class Test {
	private static final Logger LOG = LogManager.getLogger(Test.class.getName());
	private static final String USER_XML_FILE = "src/src/main/resources/User.xml";
	private static final String LOGIN_XML_FILE = "src/src/main/resources/Login.xml";
	private static final String ADDRESS_XML_FILE = "src/src/main/resources/Address.xml";
	private static final String CITY_XML_FILE = "src/src/main/resources/City.xml";
	private static final String STATE_XML_FILE = "src/src/main/resources/State.xml";
	private static final String COUNTRY_XML_FILE = "src/src/main/resources/Country.xml";
	private static final String CONTINENT_XML_FILE = "src/src/main/resources/Continent.xml";
	private static final String USER_JSON_FILE = "src/src/main/resources/User.json";

	public static void main(String[] args) {

		ContinentDao continentDao = new ContinentDao();
		Continent continent = new Continent("North America");

		try {
			continentDao.createEntity(continent);
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}

		/* read and get Continent ID making id available for use for foreign keys */
		try {
			continentDao.readEntity(1);

		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}
		continent.setId(continentDao.getContinentId());
		CountryDao countryDao = new CountryDao();
		Country country = new Country("United States", "N/A", continent.getId());

		try {
			countryDao.createEntity(country);
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}

		/* read and get country ID making id available for use for foreign keys */
		try {
			countryDao.readEntity(1);
		} catch (SQLException e) {
			LOG.error(e.getMessage());

		}
		country.setId(countryDao.getCountryId());
		StateDao stateDao = new StateDao();
		State state = new State("Florida", country.getId());

		try {
			stateDao.createEntity(state);
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}

		try {/* read and get State ID making id available for use for foreign keys */

			stateDao.readEntity(1);
		} catch (

		SQLException e) {
			LOG.error(e.getMessage());

		}

		state.setId(stateDao.getStateId());
		CityDao cityDao = new CityDao();
		City city = new City("Chrismas", "32709", state.getId());

		try {
			cityDao.createEntity(city);
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}

		try {/* read and get City ID making id available for use for foreign keys */
			cityDao.readEntity(1);
		} catch (SQLException e) {
			LOG.error(e.getMessage());

		}

		city.setId(cityDao.getCityId());
		AddressDao addressDao = new AddressDao();
		Address address = new Address(1, "Main Street", city.getId());

		try {
			addressDao.createEntity(address);
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}

		try {/* read and get Address ID making id available for use for foreign keys */

			addressDao.readEntity(1);
		} catch (

		SQLException e) {
			LOG.error(e.getMessage());

		}
		address.setId(addressDao.getAddressId());

		LoginDao loginDao = new LoginDao();
		Login login = new Login("Bob.Smith", "SmithBob");

		try {
			loginDao.createEntity(login);
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}

		try {/* read and get Login ID making id available for use for foreign keys */
			loginDao.readEntity(1);
		} catch (SQLException e) {
			LOG.error(e.getMessage());

		}
		login.setId(loginDao.getLoginId());

		Date birthDate = Date.valueOf("1970-08-19");

		UserDao userDao = new UserDao();
		User user = new User("Bob.SMith@Company.com", "Bob", "Michael", "Smith", birthDate, "222-222-2222",
				"333-333-3333", "444-444-4444", address.getId(), login.getId());

		try {
			userDao.createEntity(user);
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}

		try {/* read and get User ID making id available for use for foreign keys */
			userDao.readEntity(2);
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}

		user.setId(userDao.getUserId());

		try {
			JAXBContext jc = JAXBContext.newInstance(User.class);
			Unmarshaller u = jc.createUnmarshaller();
			Object element = u.unmarshal(new File(USER_XML_FILE));
			Marshaller m = jc.createMarshaller();

			OutputStream os = new FileOutputStream(USER_XML_FILE);
			m.marshal(element, os);
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}

		try {
			JAXBContext jc = JAXBContext.newInstance(User.class);
			Marshaller m = jc.createMarshaller();
			m.marshal(user, new File(USER_XML_FILE));

			Unmarshaller um = jc.createUnmarshaller();

		} catch (JAXBException e) {
			LOG.error("USER " + e.getMessage());
		}
		try {
			JAXBContext jc = JAXBContext.newInstance(Login.class);
			Marshaller m = jc.createMarshaller();
			m.marshal(login, new File(LOGIN_XML_FILE));
			Unmarshaller um = jc.createUnmarshaller();

		} catch (JAXBException e) {
			LOG.error("Login " + e.getMessage());
		}

		try {
			JAXBContext jc = JAXBContext.newInstance(Address.class);
			Marshaller m = jc.createMarshaller();
			m.marshal(address, new File(ADDRESS_XML_FILE));
			Unmarshaller um = jc.createUnmarshaller();

		} catch (JAXBException e) {
			LOG.error("Address " + e.getMessage());
		}
		try {
			JAXBContext jc = JAXBContext.newInstance(City.class);
			Marshaller m = jc.createMarshaller();
			m.marshal(city, new File(CITY_XML_FILE));
			Unmarshaller um = jc.createUnmarshaller();

		} catch (JAXBException e) {
			LOG.error("City " + e.getMessage());
		}
		try {
			JAXBContext jc = JAXBContext.newInstance(State.class);
			Marshaller m = jc.createMarshaller();
			m.marshal(state, new File(STATE_XML_FILE));
			Unmarshaller um = jc.createUnmarshaller();

		} catch (JAXBException e) {
			LOG.error("State " + e.getMessage());
		}
		try {
			JAXBContext jc = JAXBContext.newInstance(Country.class);
			Marshaller m = jc.createMarshaller();
			m.marshal(country, new File(COUNTRY_XML_FILE));
			Unmarshaller um = jc.createUnmarshaller();

		} catch (JAXBException e) {
			LOG.error("Country " + e.getMessage());
		}
		try {
			JAXBContext jc = JAXBContext.newInstance(Continent.class);
			Marshaller m = jc.createMarshaller();
			m.marshal(continent, new File(CONTINENT_XML_FILE));
			Unmarshaller um = jc.createUnmarshaller();

		} catch (JAXBException e) {
			LOG.error("Continent " + e.getMessage());
		}

		STaXWriter.WriteFile();

		/*
		 * try
		 * 
		 * {
		 * 
		 * LOG.debug(transformXML(4, (new StAXReader()).processXMLFile(new
		 * File(USER_XML_FILE)).toString())); } catch (FileNotFoundException e) {
		 * LOG.error("FileNotFoundException" + e.getMessage()); } catch
		 * (XMLStreamException e) { LOG.error("XMLStreamException: " + e.getMessage());
		 * } catch (FactoryConfigurationError e) {
		 * LOG.error("FactoryConfigurationError: " + e.getMessage()); } catch
		 * (TransformerException e) { LOG.error("Transformer Error: " + e.getMessage());
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
		 * streamResult); return streamResult.getWriter().toString(); }
		 */

		try {

			ObjectMapper om = new ObjectMapper();
			om.enable(SerializationFeature.INDENT_OUTPUT);
			om.configOverride(User.class)
					.setInclude(Value.construct(JsonInclude.Include.NON_NULL, JsonInclude.Include.NON_NULL));

			om.writeValue(new File(USER_JSON_FILE), user);
		} catch (IOException e) {
			LOG.error(e.getMessage());
		}

		try {
			ObjectMapper om = new ObjectMapper();

			String userJson = "{\"id\":\"2\",\"email\":\"Bob.SMith@Company.com\",\"fName\":\"Bob\",\"mName\":\"Michael\",\"lName\":\"Smith\",\"dateOfBirth\":\"19/08/1970\",\"hPhone\":\"222-222-2222\",\"cPhone\":\"333-333-3333\",\"wPhone\":\"444-444-4444\",\"addressId\":\"1\",\"loginId\":\"1\"}";
			User Bob = om.readValue(userJson, User.class);
			LOG.debug("This is JSON Bob " + Bob);

		} catch (

		Exception e) {
			LOG.error(e.getMessage());
		}

		Deadlock deadlock = new Deadlock();
		deadlock.t1.start();
		deadlock.t2.start();

	}

}
