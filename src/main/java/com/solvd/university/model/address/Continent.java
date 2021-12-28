package com.solvd.university.model.address;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.solvd.university.enums.address.CONTINENT;

public class Continent {
	private long id;
	private CONTINENT name;
	private List<Country> countries;
	private static final Logger log = LogManager.getLogger(Continent.class.getName());

	public Continent() {

	}

	public Continent(long id, CONTINENT name, List<Country> countries) {

		this.id = id;
		this.name = name;
		this.countries = countries;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public CONTINENT getName() {
		return name;
	}

	public void setName(CONTINENT name) {
		this.name = name;
	}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	@Override
	public String toString() {

		return " Continent Name : " + name;
	}

}
