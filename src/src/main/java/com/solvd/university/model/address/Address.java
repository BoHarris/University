package com.solvd.university.model.address;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "address")
@XmlType(propOrder = { "buildingNumber", "streetName", "cityId" })
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Address {
	private Long id;
	private Integer buildingNumber;
	private String streetName;
	private long cityId;

	public Address() {

	}

	public Address(Integer buildingNumber, String streetName, long cityId) {
		this.buildingNumber = buildingNumber;
		this.streetName = streetName;
		this.cityId = cityId;

	}

	@XmlAttribute(name = "id")
	public Long getId() {
		return id;
	}

	public Long setId(Long id) {
		return this.id = id;
	}

	@XmlElement(name = "buildNumber")
	public Integer getBuildingNumber() {
		return buildingNumber;
	}

	public void setBuildingNumber(Integer buildingNumber) {
		this.buildingNumber = buildingNumber;
	}

	@XmlElement(name = "streetName")
	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	@XmlElement(name = "cityId")
	public long getCityId() {
		return cityId;
	}

	public void setCityId(long cityId) {
		this.cityId = cityId;
	}

}