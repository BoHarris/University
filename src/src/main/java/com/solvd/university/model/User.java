package src.main.java.com.solvd.university.model;

import java.sql.Date;
import java.util.List;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import src.main.java.com.solvd.university.DateAdapter;
import src.main.java.com.solvd.university.model.address.Address;

@XmlRootElement(name = "user")
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
	private long addressId;
	private long loginId;
	private List<Address> addresses;
	private List<Login> logins;

	public User() {

	}

	public User(String email, String firstName, String middleName, String lastName, Date dateOfBirth, String homePhone,
			String cellPhone, String workPhone, long addressId, long loginId) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.homePhone = homePhone;
		this.cellPhone = cellPhone;
		this.workPhone = workPhone;
		this.addresses = addresses;
		this.logins = logins;
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

	@XmlElement(name = "address")
	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddressId(List<Address> addresses) {
		this.addresses = addresses;
	}

	@XmlElement(name = "login")
	public List<Login> getLogins() {
		return logins;
	}

	public void setLoginId(List<Login> logins) {
		this.logins = logins;
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
