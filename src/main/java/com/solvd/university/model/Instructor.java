package com.solvd.university.model;

import java.util.List;

public class Instructor {
	private Long id;
	private String email;
	private String phone_number;
	private List<Position> positions;
	private List<Department> departments;
	private List<Credientals> credentials;
	private List<User> users;

	public Instructor() {

	}

	public Instructor(Long id, String email, String phone_number, List<Position> positions,
			List<Department> departments, List<Credientals> credentials, List<User> users) {
		super();
		this.id = id;
		this.email = email;
		this.phone_number = phone_number;
		this.positions = positions;
		this.departments = departments;
		this.credentials = credentials;
		this.users = users;
	}

	public List<Position> getPositions() {
		return positions;
	}

	public void setPositions(List<Position> positions) {
		this.positions = positions;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	public List<Credientals> getCredentials() {
		return credentials;
	}

	public void setCredentials(List<Credientals> credentials) {
		this.credentials = credentials;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
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

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

}
