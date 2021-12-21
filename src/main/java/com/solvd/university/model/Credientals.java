package com.solvd.university.model;

public class Credientals {
	private Long id;
	private String credientals;

	public Credientals() {

	}

	public Credientals(Long id, String credientals) {
		super();
		this.id = id;
		this.credientals = credientals;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCredientals() {
		return credientals;
	}

	public void setCredientals(String credientals) {
		this.credientals = credientals;
	}

}
