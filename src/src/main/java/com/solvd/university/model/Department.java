package src.main.java.com.solvd.university.model;

import java.util.List;

public class Department {
	private Long id;
	private String name;
	private List<University> universitys;

	public Department() {

	}

	public Department(Long id, String name, List<University> universitys) {
		super();
		this.id = id;
		this.name = name;
		this.universitys = universitys;
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

	public List<University> getUniversitys() {
		return universitys;
	}

	public void setUniversitys(List<University> universitys) {
		this.universitys = universitys;
	}

}
