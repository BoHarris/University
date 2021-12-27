package com.solvd.university.model;

import com.solvd.university.enums.CREDIENTALS;

public class Credientals {
	private Long id;
	private CREDIENTALS credientals;

	public Credientals() {

	}

	public Credientals(Long id, CREDIENTALS credientals) {
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

	public CREDIENTALS getCredientals() {
		return credientals;
	}

	public void setCredientals(CREDIENTALS credientals) {
		this.credientals = credientals;
	}

}
