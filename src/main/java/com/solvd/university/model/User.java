package com.solvd.university.model;

import java.sql.Date;
import java.util.List;

import com.solvd.university.model.address.Address;

public class User {
	private Long id;
	private String email;
	private String first_name;
	private String middle_name;
	private String last_name;
	private Date dateOfBirth;
	private String home_phone;
	private String cell_phone;
	private String work_phone;
	private List<Address> addresses;
	private List<Login> logins;

	public User() {

	}

	public User(Long id, String email, String first_name, String middle_name, String last_name, String home_phone,
			String cell_phone, String work_phone, List<Address> addresses, List<Login> logins) {
		super();
		this.id = id;
		this.email = email;
		this.first_name = first_name;
		this.middle_name = middle_name;
		this.last_name = last_name;
		this.home_phone = home_phone;
		this.cell_phone = cell_phone;
		this.work_phone = work_phone;
		this.addresses = addresses;
		this.logins = logins;
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

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getHome_phone() {
		return home_phone;
	}

	public void setHome_phone(String home_phone) {
		this.home_phone = home_phone;
	}

	public String getCell_phone() {
		return cell_phone;
	}

	public void setCell_phone(String cell_phone) {
		this.cell_phone = cell_phone;
	}

	public String getWork_phone() {
		return work_phone;
	}

	public void setWork_phone(String work_phone) {
		this.work_phone = work_phone;
	}

	public List<Address> getAddressId() {
		return addresses;
	}

	public void setAddressId(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Login> getLoginId() {
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
