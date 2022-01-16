package src.main.java.com.solvd.university.model.address;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

@XmlRootElement(name = "country")
@XmlType(propOrder = { "name", "countryCode", "continentId", "states" })
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Country {
	private long id;
	private String name;
	private String countryCode;
	private long continentId;
	private List<State> states;

	private static final Logger LOG = LogManager.getLogger(Country.class.getName());

	public Country() {

	}

	public Country(String name, String countryCode, long continentId) {

		this.name = name;
		this.countryCode = countryCode;
		this.continentId = continentId;

	}

	@XmlAttribute(name = "id")
	public long getId() {
		return id;
	}

	public Long setId(long id) {
		return this.id = id;
	}

	@XmlElement(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name = "countryCode")
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	@XmlElement(name = "states")
	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

	@XmlElement(name = "continentId")
	public long getContinentId() {
		return continentId;
	}

	public void setContinentId(Long continentId) {
		this.continentId = continentId;
	}

	@Override
	public String toString() {

		return " Country Name : " + name + " Country Code : " + countryCode + " Continent  " + continentId + "\n";
	}

}
