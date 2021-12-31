package src.main.java.com.solvd.university.model;

public class Prerequisite {
	private Long id;
	private String requiredHour;

	public Prerequisite() {

	}

	public Prerequisite(Long id, String requiredHour) {
		super();
		this.id = id;
		this.requiredHour = requiredHour;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRequiredHour() {
		return requiredHour;
	}

	public void setRequiredHour(String requiredHour) {
		this.requiredHour = requiredHour;
	}

}
