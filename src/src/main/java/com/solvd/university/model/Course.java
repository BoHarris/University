package com.solvd.university.model;

import java.util.List;

public class Course {
	private Long id;
	private String name;
	private String creditHours;
	private List<Term> terms;
	private List<Prerequisite> prerequisits;
	private List<Department> departments;
	private List<CourseMaterial> courseMaterials;
	private List<Instructor> instructors;

	public Course() {

	}

	public List<Prerequisite> getPrerequisits() {
		return prerequisits;
	}

	public void setPrerequisits(List<Prerequisite> prerequisits) {
		this.prerequisits = prerequisits;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	public List<CourseMaterial> getCourseMaterials() {
		return courseMaterials;
	}

	public void setCourseMaterials(List<CourseMaterial> courseMaterials) {
		this.courseMaterials = courseMaterials;
	}

	public List<Instructor> getInstructors() {
		return instructors;
	}

	public void setInstructors(List<Instructor> instructors) {
		this.instructors = instructors;
	}

	public Course(Long id, String name, String creditHours, List<Prerequisite> prerequisits,
			List<Department> departments, List<Term> terms, List<CourseMaterial> courseMaterials,
			List<Instructor> instructors) {
		this.id = id;
		this.name = name;
		this.creditHours = creditHours;
		this.prerequisits = prerequisits;
		this.departments = departments;
		this.terms = terms;
		this.courseMaterials = courseMaterials;
		this.instructors = instructors;
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

	public List<Term> getTerms() {
		return terms;
	}

	public void setTermId(List<Term> terms) {
		this.terms = terms;
	}

}
