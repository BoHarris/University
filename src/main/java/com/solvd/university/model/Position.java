package com.solvd.university.model;

import com.solvd.university.enums.POSITION;

public class Position {
	private Long id;
	private POSITION name;

	public Position() {

	}

	public Position(Long id, POSITION name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public POSITION getName() {
		return name;
	}

	public void setName(POSITION name) {
		this.name = name;
	}

}
