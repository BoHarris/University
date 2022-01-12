package src.main.java.com.solvd.university.model;

import java.sql.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import src.main.java.com.solvd.university.DateAdapter;

@XmlRootElement(name = "user")
@XmlType(propOrder = {  "email", "firstName", "middleName", "lastName", "dateOfBirth", "homePhone", "cellPhone",
		"workPhone", "addressId", "loginId" })
@XmlAccessorType(XmlAccessType.PROPERTY)

public class User {

	private Long id;
	private String email;
	private String firstName;
	private String middleName;
	private String lastName;
	private Date dateOfBirth;
	private String homePhone;
	private String cellPhone;
	private String workPhone;
	private Long addressId;
	private Long loginId;

	public User() {

	}

	public User(String email, String firstName, String middleName, String lastName, Date dateOfBirth, String homePhone,
			String cellPhone, String workPhone, long addressId, long loginId) {

		this.email = email;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.homePhone = homePhone;
		this.cellPhone = cellPhone;
		this.workPhone = workPhone;
		this.addressId = addressId;
		this.loginId = loginId;
	}

	@XmlAttribute(name = "id")
	public Long getId() {
		return id;
	}

	public Long setId(Long id) {
		return this.id = id;
	}

	@XmlElement(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@XmlElement(name = "fName")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@XmlElement(name = "mName")
	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@XmlElement(name = "lName")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@XmlJavaTypeAdapter(DateAdapter.class)
	public java.sql.Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@XmlElement(name = "hPhone")
	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	@XmlElement(name = "cPhone")
	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	@XmlElement(name = "wPhone")
	public String getWorkPhone() {
		return workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	@XmlElement(name = "addressId")
	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	@XmlElement(name = "loginId")
	public long getLoginId() {
		return loginId;
	}

	public void setLoginId(long loginId) {
		this.loginId = loginId;
	}

}
