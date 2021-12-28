package com.solvd.university.model.address;

import com.solvd.university.enums.address.COUNTRY;
import com.solvd.university.enums.address.STATE;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Country {
	private long id;
	private COUNTRY countryName;
	private STATE stateName;
	private String countryCode;
	private List<State> states;

	private static final Logger log = LogManager.getLogger(Country.class.getName());

	public Country() {

	}

	public Country(long id, COUNTRY countryName, String countryCode, STATE state, List<State> states) {

		this.id = id;
		this.countryName = countryName;
		this.countryCode = countryCode;
		this.stateName = state;
		this.states = states;

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

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public STATE getStateName() {
		return stateName;
	}

	public void setStateName(STATE stateName) {
		this.stateName = stateName;
	}

	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

	@Override
	public String toString() {

		return " Country Name : " + countryName + " Country Code : " + countryCode + "\n";
	}

}
