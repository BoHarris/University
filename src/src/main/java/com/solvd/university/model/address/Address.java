package src.main.java.com.solvd.university.model.address;

import java.util.List;

public class Address {
	private Long id;
	private Integer buildingNumber;
	private String streetName;
	private long cityId;
	private List<City> citys;

	public Address() {

	}

	public Address(Integer buildingNumber, String streetName, long cityId) {
		this.buildingNumber = buildingNumber;
		this.streetName = streetName;
		this.cityId = cityId;

	}

	public Long getId() {
		return id;
	}

	public Long setId(Long id) {
		return this.id = id;
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

	public long getCityId() {
		return cityId;
	}

	public void setCityId(long cityId) {
		this.cityId = cityId;
	}

	public List<City> getCity() {
		return citys;
	}

	public void setCity(List<City> citys) {
		this.citys = citys;
	}

}
