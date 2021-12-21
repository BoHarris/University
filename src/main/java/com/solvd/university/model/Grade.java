package com.solvd.university.model;

public class Grade {
	private Long id;
	private Integer grade;
	private Long undergraduate;

	public Grade() {

	}

	public Grade(Long id, Integer grade, Long undergraduate) {
		super();
		this.id = id;
		this.grade = grade;
		this.undergraduate = undergraduate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Long getUndergraduate() {
		return undergraduate;
	}

	public void setUndergraduate(Long undergraduate) {
		this.undergraduate = undergraduate;
	}

}
