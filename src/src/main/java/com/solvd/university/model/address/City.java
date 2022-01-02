package src.main.java.com.solvd.university.model.address;

public class City {
	private Long id;
	private String name;
	private String zipCode;
	private long stateId;

	public City() {

	}

	public City(String name, String zipCode, long stateId) {
		this.name = name;
		this.zipCode = zipCode;
		this.setStateId(stateId);
	}

	public Long getId() {
		return id;
	}

	public Long setId(Long id) {
		return this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public long getStateId() {
		return stateId;
	}

	public void setStateId(long stateId) {
		this.stateId = stateId;
	}
}
