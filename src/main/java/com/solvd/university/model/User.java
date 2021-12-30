package com.solvd.university.model;

import java.sql.Array;
import java.sql.Date;
import java.util.List;

import com.solvd.university.model.address.Address;

public class User {
	private Long id;
	private String email;
	private String firstName;
	private String middleName;
	private String lastName;
	private Date dateOfBirth;
	private String homePhone;
	private String cellPhone;
	private String workPhone;
	private long addressId;
	private long loginId;
	private List<Address> addresses;
	private List<Login> logins;

	public User() {

	}

	public User( String email, String firstName, String middleName, String lastName, Date dateOfBirth,
			String homePhone, String cellPhone, String workPhone, long addressId, long loginId) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.homePhone = homePhone;
		this.cellPhone = cellPhone;
		this.workPhone = workPhone;
		this.addresses = addresses;
		this.logins = logins;
		this.addressId = addressId;
		this.loginId = loginId;
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public long getLoginId() {
		return loginId;
	}

	public void setLoginId(long loginId) {
		this.loginId = loginId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getmiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getlastName() {
		return lastName;
	}

	public void setlastName(String lastName) {
		this.lastName = lastName;
	}

	public String gethomePhone() {
		return homePhone;
	}

	public void sethomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getcellPhone() {
		return cellPhone;
	}

	public void setcellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getworkPhone() {
		return workPhone;
	}

	public void setworkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddressId(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Login> getLogins() {
		return logins;
	}

	public void setLoginId(List<Login> logins) {
		this.logins = logins;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
