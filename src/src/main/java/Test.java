package src.main.java;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import src.main.java.com.solvd.university.DAO.mysqlimpl.ContinentDao;
import src.main.java.com.solvd.university.DAO.mysqlimpl.CountryDao;
import src.main.java.com.solvd.university.model.address.Continent;
import src.main.java.com.solvd.university.model.address.Country;

public class Test {
	private static final Logger log = LogManager.getLogger(Test.class.getName());
	private static final String FILE_NAME = "resources/User.xml";

	public static void main(String[] args) throws InterruptedException {

		ContinentDao continentDao = new ContinentDao();
		Continent continent = new Continent("here");
		/*
		 * try { continentDao.createEntity(continent); } catch (SQLException e) {
		 * log.error(e.getMessage()); }
		 */

		try {
			continentDao.readEntity(4);

		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		try {
			continentDao.readEntity(1);

		} catch (SQLException e) {
			log.error(e.getMessage());
		}

		CountryDao countryDao = new CountryDao();
		Country country = new Country("United States", "N/A", 1);

		/*
		 * try { countryDao.createEntity(country); } catch (SQLException e) {
		 * log.error(e.getMessage()); }
		 */
		try {
			countryDao.readEntity(1);
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