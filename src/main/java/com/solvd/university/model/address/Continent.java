package com.solvd.university.model.address;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Continent {
	private long id;
	private String name;
	private List<Country> countries;
	private static final Logger log = LogManager.getLogger(Continent.class.getName());

	public Continent() {

	}

	public Continent(String name) {

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
