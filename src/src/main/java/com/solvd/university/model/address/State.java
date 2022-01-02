package src.main.java.com.solvd.university.model.address;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class State {
	private long id;
	private String name;
	private long countryId;
	private List<City> cities;
	private static final Logger log = LogManager.getLogger(State.class.getName());

	public State() {

	}

	public State(String name, long countryId) {

		this.name = name;
		this.countryId = countryId;

	}

	public long getId() {
		return id;
	}

	public Long setId(long id) {
		return this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
