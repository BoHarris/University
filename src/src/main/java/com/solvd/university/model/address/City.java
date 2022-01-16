package src.main.java.com.solvd.university.model.address;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "city")
@XmlType(propOrder = { "name", "zipCode", "stateId", "addresses" })
@XmlAccessorType(XmlAccessType.PROPERTY)
public class City {
	private long id;
	private String name;
	private String zipCode;
	private long stateId;
	private List<Address> addresses;

	public City() {

	}

	public City(String name, String zipCode, long stateId) {
		this.name = name;
		this.zipCode = zipCode;
		this.setStateId(stateId);
	}

	@XmlAttribute(name = "id")
	public long getId() {
		return id;
	}

	public Long setId(long id) {
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

	@XmlElement(name = "addresses")
	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
}
