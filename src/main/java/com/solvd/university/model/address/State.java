package com.solvd.university.model.address;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.solvd.university.enums.address.COUNTRY;
import com.solvd.university.enums.address.STATE;

public class State {
	private long id;
	private STATE name;
	private COUNTRY countryName;
	private long countryId;
	private List<City> cities;
	private static final Logger log = LogManager.getLogger(Country.class.getName());

	public State() {

	}

	public State(STATE name, COUNTRY countryName, long countryId, List<City> cities) {

		this.name = name;
		this.countryName = countryName;
		this.countryId = countryId;
		this.cities = cities;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public COUNTRY getCountry() {
		return countryName;
	}

	public void setCountry(COUNTRY countryName) {
		this.countryName = countryName;
	}

	public STATE getName() {
		return name;
	}

	public void setName(STATE name) {
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
