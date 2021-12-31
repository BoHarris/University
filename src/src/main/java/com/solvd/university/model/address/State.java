package src.main.java.com.solvd.university.model.address;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class State {
	private long id;
	private String name;
	private String zipCode;
	private long countryId;
	private List<City> cities;
	private static final Logger log = LogManager.getLogger(State.class.getName());

	public State() {

	}

	public State(String name, String zipCode) {

		this.name = name;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public long getCountryId() {
		return countryId;
	}

	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	@Override
	public String toString() {

		return " State Name : " + name + "\n";
	}
}
