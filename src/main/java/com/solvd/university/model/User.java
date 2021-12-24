package com.solvd.university.model;

import java.util.List;

public class User {
	private Long id;
	private String email;
	private String first_name;
	private String middle_name;
	private String last_name;
	private String home_phone;
	private String cell_phone;
	private String work_phone;
	private Long addressId;
	private Long loginId;

	public User() {

	}

	public User(Long id, String email, String first_name, String middle_name, String last_name, String home_phone,
			String cell_phone, String work_phone, Long addressId, Long loginId) {
		super();
		this.id = id;
		this.email = email;
		this.first_name = first_name;
		this.middle_name = middle_name;
		this.last_name = last_name;
		this.home_phone = home_phone;
		this.cell_phone = cell_phone;
		this.work_phone = work_phone;
		this.addressId = addressId;
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

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public Long getLoginId() {
		return loginId;
	}

	public void setLoginId(Long loginId) {
		this.loginId = loginId;
	}

	public void setAddressId(List addressById) {

	}

	public void setLoginId(List loginById) {

	}

	public void setLoginId(Login loginById) {

	}

}
