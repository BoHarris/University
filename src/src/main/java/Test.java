package src.main.java;

import java.sql.Date;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
	private static final Logger log = LogManager.getLogger(Test.class.getName());
	private static final String FILE_NAME = "resources/User.xml";

	public static void main(String[] args) {
		ContinentDao continentDao = new ContinentDao();
		Continent continent = new Continent("North America");

		try {
			continentDao.createEntity(continent);
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		/* read and get Continent ID making id available for use for foreign keys */
		try {
			continentDao.readEntity(1);

		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		continent.setId(continentDao.getContinentId());
		CountryDao countryDao = new CountryDao();
		Country country = new Country("United States", "N/A", continent.getId());

		try {
			countryDao.createEntity(country);
		} catch (SQLException e) {
			log.error(e.getMessage());
		}

		/* read and get country ID making id available for use for foreign keys */
		try {
			countryDao.readEntity(1);
		} catch (SQLException e) {
			log.error(e.getMessage());

		}
		country.setId(countryDao.getCountryId());
		StateDao stateDao = new StateDao();
		State state = new State("Florida", country.getId());

		try {
			stateDao.createEntity(state);
		} catch (SQLException e) {
			log.error(e.getMessage());
		}

		try {/* read and get State ID making id available for use for foreign keys */
			stateDao.readEntity(1);
		} catch (SQLException e) {
			log.error(e.getMessage());

		}

		state.setId(stateDao.getStateId());
		CityDao cityDao = new CityDao();
		City city = new City("Chrismas", "32709", state.getId());

		try {
			cityDao.createEntity(city);
		} catch (SQLException e) {
			log.error(e.getMessage());
		}

		try {/* read and get City ID making id available for use for foreign keys */
			cityDao.readEntity(1);
		} catch (SQLException e) {
			log.error(e.getMessage());

		}

		city.setId(cityDao.getCityId());
		AddressDao addressDao = new AddressDao();
		Address address = new Address(1, "Main Street", city.getId());

		try {
			addressDao.createEntity(address);
		} catch (SQLException e) {
			log.error(e.getMessage());
		}

		try {/* read and get Address ID making id available for use for foreign keys */
			addressDao.readEntity(1);
		} catch (SQLException e) {
			log.error(e.getMessage());

		}
		address.setId(addressDao.getAddressId());
		System.out.println(address.getId());

		LoginDao loginDao = new LoginDao();
		Login login = new Login("Bob.Smith", "SmithBob");

		try {
			loginDao.createEntity(login);
		} catch (SQLException e) {
			log.error(e.getMessage());
		}

		try {/* read and get Login ID making id available for use for foreign keys */
			loginDao.readEntity(1);
		} catch (SQLException e) {
			log.error(e.getMessage());

		}
		login.setId(loginDao.getLoginId());

		Date birthDate = Date.valueOf("1970-08-19");

		UserDao userDao = new UserDao();
		User user = new User("Bob.SMith@Company.com", "Bob", "Michael", "Smith", birthDate, "222-222-2222",
				"333-333-3333", "444-444-4444", address.getId(), login.getId());

		try {
			userDao.createEntity(user);
		} catch (SQLException e) {
			log.error(e.getMessage());
		}

		try {
			userDao.readEntity(1);
		} catch (SQLException e) {
			log.error(e.getMessage());
		}

	}
}

/*
 * try{
 * 
 * log.debug(transformXML(4,(new StAXHandler()).processXMLFile(new
 * File(FILE_NAME)).toString()));}catch( FileNotFoundException e) {
 * log.error("FileNotFoundException" + e.getMessage()); }catch(
 * XMLStreamException e) { log.error("XMLStreamException: " + e.getMessage());
 * }catch( FactoryConfigurationError e) {
 * log.error("FactoryConfigurationError: " + e.getMessage()); }catch(
 * TransformerException e) { log.error("Transformer Error: " + e.getMessage());
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
 * }}
 */