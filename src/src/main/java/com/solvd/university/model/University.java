package src.main.java.com.solvd.university.model;

import java.util.List;

import src.main.java.com.solvd.university.model.address.Address;

public class University {
	private Long id;
	private String name;
	private String phoneNumber;
	private Address addressId;
	private List<Address> addresses;

	public University() {

	}

	public University(Long id, String name, String phoneNumber, List<Address> addresses) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.setAddresses(addresses);
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public Address getAddressId() {
		return addressId;
	}

	public Address setAddressId(Address addressId) {
		this.addressId = addressId;
		return addressId;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Address setAddresses(Address addressById) {
		return addressId = addressById;

	}

}
