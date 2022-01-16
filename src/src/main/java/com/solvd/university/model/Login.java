package src.main.java.com.solvd.university.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "user")
@XmlType(propOrder = { "name", "password" })
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Login {
	private long id;
	private String name;
	private String password;

	public Login() {

	}

	public Login(String name, String password) {
		super();
		this.name = name;
		this.password = password;
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

	@XmlElement(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
