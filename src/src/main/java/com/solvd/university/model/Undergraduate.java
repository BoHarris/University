package src.main.java.com.solvd.university.model;

import java.sql.Date;
import java.util.List;

public class Undergraduate {
	private Long id;
	private long userId;
	private Date dateEnrolled;
	private List<User> users;
	private List<Course> courses;

	public Undergraduate() {

	}

	public Undergraduate(Long id, List<User> users, List<Course> courses) {
		super();
		this.id = id;
		this.users = users;
		this.courses = courses;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Date getDateEnrolled() {
		return dateEnrolled;
	}

	public void setDateEnrolled(Date dateEnrolled) {
		this.dateEnrolled = dateEnrolled;
	}


}
