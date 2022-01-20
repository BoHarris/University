package com.solvd.university.test;

import java.sql.Date;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

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

public class TestNG {
	private static final Logger LOG = LogManager.getLogger(TestNG.class.getName());

	// Pre-condition annotations
	@BeforeSuite
	public void beforeSuit() {

		LOG.debug("@BeforeSuite - Executed 1st");

	}

	@BeforeTest
	public void beforeTest() {
		LOG.debug("@BeforeTest - Executed 2rd");
	}

	@BeforeClass
	public void beforeClass() {
		LOG.debug("@BeforeClass - executed 3th");
	}

	@BeforeMethod
	public void beforeMethod() {
		LOG.debug("@BeforeMethod - executed 4th");
	}

	@BeforeGroups
	public void beforeGroup() {
		LOG.debug("@BeforeGroups - Executed 5nd");
	}

	// test case annotation
	@Parameters({ "id", "dateOfBirth", "addressId", "loginId" })
	@Test(dataProvider = "getData")

	public void testOne(long id, String email, String firstName, String middleName, String lastName, Date dateOfBirth,
			String homePhone, String cellPhone, String workPhone, long addressId, long loginId) {

		LOG.debug("@Test - Executed 6 -- @BeforeMethod -> testOne -> @AfterMethod group One" + firstName);
	}

	@Test(groups = { "functest", "testTwo" })
	public void testTwo() {
		LOG.debug("@Test - @BeforeMethod -> testTwo -> @AfterMethod Group Two");
	}

	@Test(groups = { "functest", "testThree" })

	public void testThree() {
		LOG.debug("@Test - @BeforeMethod -> testThree -> @AfterMethod Group Three");
	}

	// post-condition test annotations
	@AfterGroups
	public void afterGroup() {
		LOG.debug("@Test - Executed 7");
	}

	@AfterMethod
	public void afterMethod() {
		LOG.debug("@AfterMethod - Executed 8");
	}

	@AfterClass
	public void afterClass() {
		LOG.debug("@AfterClass - Executed 9th");
	}

	@AfterTest
	public void afterTest() {
		LOG.debug("@AfterTest - Executed 10th");
	}

	@AfterSuite
	public void afterSuite() {
		LOG.debug("@AfterSuite - Executed 11th");
	}

	@DataProvider(name = "getData")
	public Object[][] getData() {
		ContinentDao continentDao = new ContinentDao();
		Continent continent = new Continent("North America");

		/* read and get Continent ID making id available for use for foreign keys */
		try {
			continentDao.readEntity(1);

		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}
		continent.setId(continentDao.getContinentId());
		CountryDao countryDao = new CountryDao();
		Country country = new Country("United States", "N/A", continent.getId());

		/* read and get country ID making id available for use for foreign keys */
		try {
			countryDao.readEntity(1);
		} catch (SQLException e) {
			LOG.error(e.getMessage());

		}
		country.setId(countryDao.getCountryId());
		StateDao stateDao = new StateDao();
		State state = new State("Florida", country.getId());

		try {/* read and get State ID making id available for use for foreign keys */

			stateDao.readEntity(1);
		} catch (

		SQLException e) {
			LOG.error(e.getMessage());

		}

		state.setId(stateDao.getStateId());
		CityDao cityDao = new CityDao();
		City city = new City("Chrismas", "32709", state.getId());

		try {/* read and get City ID making id available for use for foreign keys */
			cityDao.readEntity(1);
		} catch (SQLException e) {
			LOG.error(e.getMessage());

		}

		city.setId(cityDao.getCityId());
		AddressDao addressDao = new AddressDao();
		Address address = new Address(1, "Main Street", city.getId());

		try {/* read and get Address ID making id available for use for foreign keys */

			addressDao.readEntity(1);
		} catch (

		SQLException e) {
			LOG.error(e.getMessage());

		}
		address.setId(addressDao.getAddressId());

		LoginDao loginDao = new LoginDao();
		Login login = new Login("Bob.Smith", "SmithBob");

		try {/* read and get Login ID making id available for use for foreign keys */
			loginDao.readEntity(1);
		} catch (SQLException e) {
			LOG.error(e.getMessage());

		}
		login.setId(loginDao.getLoginId());

		Date birthDate = Date.valueOf("1970-08-19");

		UserDao userDao = new UserDao();
		try {/* read and get Login ID making id available for use for foreign keys */
			userDao.readEntity(1);
		} catch (SQLException e) {
			LOG.error(e.getMessage());

		}
		User user = new User("Bob.SMith@Company.com", "Bob", "Michael", "Smith", birthDate, "222-222-2222",
				"333-333-3333", "444-444-4444", address.getId(), login.getId());
		user.setId(userDao.getUserId());

		Object[][] data = new Object[1][11];
		data[0][0] = user.getId();
		data[0][1] = user.getEmail();
		data[0][2] = user.getFirstName();
		data[0][3] = user.getMiddleName();
		data[0][4] = user.getLastName();
		data[0][5] = user.getDateOfBirth();
		data[0][6] = user.getWorkPhone();
		data[0][7] = user.getCellPhone();
		data[0][8] = user.getHomePhone();
		data[0][9] = user.getAddressId();
		data[0][10] = user.getLoginId();

		return data;
	}

}
