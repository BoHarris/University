package src.main.java.com.solvd.university.model.address;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import src.main.java.com.solvd.university.DAO.mysqlimpl.ContinentDao;

public class Continent {
	private long id;
	private String name;
	ContinentDao continentId;
	private List<Country> countries;
	private static final Logger log = LogManager.getLogger(Continent.class.getName());

	public Continent() {

	}

	public Continent(String name) {
		this.id = id;
		this.name = name;

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

	public String setName(String name) {
		return this.name = name;
	}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	@Override
	public String toString() {
		return "Continent [id=" + id + ", name=" + name + "]";
	}

}
