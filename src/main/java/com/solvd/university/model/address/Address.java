package com.solvd.university.model.address;

import java.util.List;

public class Address {
	private Long id;
	private Integer buildingNumber;
	private String streetName;
	private List<City> citys;

	public Address() {

	}

	public Address(Long id, Integer buildingNumber, String streetName, List<City> citys) {
		this.id = id;
		this.buildingNumber = buildingNumber;
		this.streetName = streetName;
		this.citys = citys;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getBuildingNumber() {
		return buildingNumber;
	}

	public void setBuildingNumber(Integer buildingNumber) {
		this.buildingNumber = buildingNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public List<City> getCity() {
		return citys;
	}

	public void setCity(List<City> citys) {
		this.citys = citys;
	}

}
