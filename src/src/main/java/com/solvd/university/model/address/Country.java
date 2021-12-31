package src.main.java.com.solvd.university.model.address;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Country {
	private long id;
	private String name;
	private String countryCode;
	private long contientId;
	private List<State> states;

	private static final Logger log = LogManager.getLogger(Country.class.getName());

	public Country() {

	}

	public Country(String name, String countryCode, long contientId) {

		this.name = name;
		this.countryCode = countryCode;
		this.contientId = contientId;

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

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

	public long getContientId() {
		return contientId;
	}

	public void setContientId(long contientId) {
		this.contientId = contientId;
	}

	@Override
	public String toString() {

		return " Country Name : " + name + " Country Code : " + countryCode + "\n";
	}

}
