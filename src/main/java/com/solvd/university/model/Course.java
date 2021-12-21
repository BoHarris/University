package com.solvd.university.model;

public class Course {
	private Long id;
	private String name;
	private String creditHours;
	private Long prerequisitId;
	private Long departmentId;
	private Long termId;
	private Long courseMaterialId;
	private Long instructorId;

	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Course(Long id, String name, String creditHours, Long prerequisitId, Long departmentId, Long termId,
			Long courseMaterialId, Long instructorId) {
		this.id = id;
		this.name = name;
		this.creditHours = creditHours;
		this.prerequisitId = prerequisitId;
		this.departmentId = departmentId;
		this.termId = termId;
		this.courseMaterialId = courseMaterialId;
		this.instructorId = instructorId;
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

	public String getCreditHours() {
		return creditHours;
	}

	public void setCreditHours(String creditHours) {
		this.creditHours = creditHours;
	}

	public Long getPrerequisitId() {
		return prerequisitId;
	}

	public void setPrerequisitId(Long prerequisitId) {
		this.prerequisitId = prerequisitId;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long getTermId() {
		return termId;
	}

	public void setTermId(Long termId) {
		this.termId = termId;
	}

	public Long getCourseMaterialId() {
		return courseMaterialId;
	}

	public void setCourseMaterialId(Long courseMaterialId) {
		this.courseMaterialId = courseMaterialId;
	}

	public Long getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(Long instructorId) {
		this.instructorId = instructorId;
	}

}
