package com.solvd.university.model;

public class Instructor {
	private Long id;
	private String email;
	private String phone_number;
	private Long position_id;
	private Long department_id;
	private Long credentials_id;
	private Long user_id;

	public Instructor() {

	}

	public Instructor(Long id, String email, String phone_number, Long position_id, Long department_id,
			Long credentials_id, Long user_id) {
		super();
		this.id = id;
		this.email = email;
		this.phone_number = phone_number;
		this.position_id = position_id;
		this.department_id = department_id;
		this.credentials_id = credentials_id;
		this.user_id = user_id;
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

	public Long getPosition_id() {
		return position_id;
	}

	public void setPosition_id(Long position_id) {
		this.position_id = position_id;
	}

	public Long getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(Long department_id) {
		this.department_id = department_id;
	}

	public Long getCredentials_id() {
		return credentials_id;
	}

	public void setCredentials_id(Long credentials_id) {
		this.credentials_id = credentials_id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

}
