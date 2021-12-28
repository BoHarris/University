package com.solvd.university.model.address;

public class City {
	private Long id;
	private String name;
	private String zipCode;
	
	public City() {

	}

	public City(Long id, String name, String zipCode) {
		this.id = id;
		this.name = name;
		this.zipCode = zipCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
}
