package src.main.java.com.solvd.university.model;

import java.util.List;

public class Grade {
	private Long id;
	private Integer grade;
	private List<Undergraduate> undergraduates;

	public Grade() {

	}

	public Grade(Long id, Integer grade, List<Undergraduate> undergraduates) {
		super();
		this.id = id;
		this.grade = grade;
		this.setUndergraduates(undergraduates);
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

	public List<Undergraduate> getUndergraduates() {
		return undergraduates;
	}

	public void setUndergraduates(List<Undergraduate> undergraduate) {
		this.undergraduates = undergraduate;
	}

}
