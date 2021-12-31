package src.main.java.com.solvd.university.DAO.mysqlimpl;

import java.sql.SQLException;
import java.util.List;

import src.main.java.com.solvd.university.DAO.IInstructorDao;
import src.main.java.com.solvd.university.model.Instructor;

public class InstructorDao extends AbstractMySQLDao implements IInstructorDao<Instructor> {

	@Override
	public void createEntity(Instructor entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Instructor readEntity(long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEntity(Instructor entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEntinty(long id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Instructor> getInstructorById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
