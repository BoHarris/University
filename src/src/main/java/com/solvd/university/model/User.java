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
	@XmlElement(name = "fName")
	private String firstName;
	@XmlElement(name = "mName")
	private String middleName;
	@XmlElement(name = "lName")
	private String lastName;
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date dateOfBirth;
	@XmlElement(name = "hPhone")
	private String homePhone;
	@XmlElement(name = "cPhone")
	private String cellPhone;
	@XmlElement(name = "wPhone")
	private String workPhone;
	@XmlElement(name = "addressId")
	private long addressId;
	@XmlElement(name = "loginId")
	private long loginId;
	@XmlElement(name = "address")
	private List<Address> addresses;
	@XmlElement(name = "login")
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

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public long getLoginId() {
		return loginId;
	}

	public void setLoginId(long loginId) {
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddressId(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Login> getLogins() {
		return logins;
	}

	public void setLoginId(List<Login> logins) {
		this.logins = logins;
	}

	public java.sql.Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
