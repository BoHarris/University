package com.solvd.university.model;

public class Undergraduate {
	private Long id;
	private Long userId;
	private Long courseId;

	public Undergraduate() {

	}

	public Undergraduate(Long id, Long userId, Long courseId) {
		super();
		this.id = id;
		this.userId = userId;
		this.courseId = courseId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

}
