package src.main.java.com.solvd.university.DAO.mysqlimpl;

import java.sql.SQLException;
import java.util.List;

import src.main.java.com.solvd.university.DAO.IUniversityDao;
import src.main.java.com.solvd.university.model.University;

public class UniversityDao extends AbstractMySQLDao implements IUniversityDao<University> {

	@Override
	public void createEntity(University entity) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public University readEntity(long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEntity(University entity) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteEntinty(long id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<University> getUniversityById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
