package src.main.java.com.solvd.university.DAO.mysqlimpl;

import java.sql.SQLException;
import java.util.List;

import src.main.java.com.solvd.university.DAO.ITermDao;
import src.main.java.com.solvd.university.model.Term;

public class TermDao extends AbstractMySQLDao implements ITermDao<Term> {

	@Override
	public void createEntity(Term entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Term readEntity(long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEntity(Term entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEntinty(long id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Term> getTermById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
