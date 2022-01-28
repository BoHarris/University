package com.solvd.university.model.address;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

@XmlRootElement(name = "state")
@XmlType(propOrder = { "id", "name", "countryId", "cities" })
@XmlAccessorType(XmlAccessType.PROPERTY)
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

	@XmlElement(name = "countryId")
	public long getCountryId() {
		return countryId;
	}

	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}

	@XmlElement(name = "cities")
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
