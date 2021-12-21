package com.solvd.university.model;

public class Address {
	private Long id;
	private Integer buildingNumber;
	private String streetName;
	private Long cityId;

	public Address() {

	}

	public Address(Long id, Integer buildingNumber, String streetName, Long cityId) {
		this.id = id;
		this.buildingNumber = buildingNumber;
		this.streetName = streetName;
		this.cityId = cityId;
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

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
}
