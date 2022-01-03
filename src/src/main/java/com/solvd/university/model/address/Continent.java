package src.main.java.com.solvd.university.model.address;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
@XmlRootElement(name = "continent")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Continent {
	private long id;
	private String name;
	private List<Country> countries;
	private static final Logger log = LogManager.getLogger(Continent.class.getName());

	public Continent() {

	}

	public Continent(String name) {
		this.name = name;

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

	public String setName(String name) {
		return this.name = name;
	}

	@XmlElement(name = "countries")
	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	@Override
	public String toString() {
		return "Continent [id=" + id + ", name=" + name + "]";
	}

}
