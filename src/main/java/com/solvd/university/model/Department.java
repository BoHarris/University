package com.solvd.university.model;

public class Department {
	private Long id;
	private String name;
	private Long universityId;

	public Department() {

	}

	public Department(Long id, String name, Long universityId) {
		super();
		this.id = id;
		this.name = name;
		this.universityId = universityId;
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

	public Long getUniversityId() {
		return universityId;
	}

	public void setUniversityId(Long universityId) {
		this.universityId = universityId;
	}

}
