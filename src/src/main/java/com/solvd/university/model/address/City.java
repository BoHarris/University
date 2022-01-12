package src.main.java.com.solvd.university.model.address;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "city")
@XmlType(propOrder = { "name", "zipCode", "stateId" })
@XmlAccessorType(XmlAccessType.PROPERTY)
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

	@XmlAttribute(name = "id")
	public Long getId() {
		return id;
	}

	public Long setId(Long id) {
		return this.id = id;
	}

	@XmlElement(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name = "zipCode")
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@XmlElement(name = "stateId")
	public long getStateId() {
		return stateId;
	}

	public void setStateId(long stateId) {
		this.stateId = stateId;
	}
}
