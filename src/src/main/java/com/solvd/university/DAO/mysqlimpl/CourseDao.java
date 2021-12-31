package src.main.java.com.solvd.university.DAO.mysqlimpl;

import java.sql.SQLException;
import java.util.List;

import src.main.java.com.solvd.university.DAO.ICourseDao;
import src.main.java.com.solvd.university.model.Course;

public class CourseDao extends AbstractMySQLDao implements ICourseDao<Course> {

	@Override
	public void createEntity(Course entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Course readEntity(long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEntity(Course entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEntinty(long id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Course> getCourseById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
