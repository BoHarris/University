package src.main.java.com.solvd.university.service;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import src.main.java.com.solvd.university.DAO.ICourseDao;
import src.main.java.com.solvd.university.DAO.ICourseMaterialDao;
import src.main.java.com.solvd.university.DAO.IDepartmentDao;
import src.main.java.com.solvd.university.DAO.IInstructorDao;
import src.main.java.com.solvd.university.DAO.IPrerequisiteDao;
import src.main.java.com.solvd.university.DAO.ITermDao;
import src.main.java.com.solvd.university.DAO.mysqlimpl.CourseDao;
import src.main.java.com.solvd.university.DAO.mysqlimpl.CourseMaterialDao;
import src.main.java.com.solvd.university.DAO.mysqlimpl.DepartmentDao;
import src.main.java.com.solvd.university.DAO.mysqlimpl.InstructorDao;
import src.main.java.com.solvd.university.DAO.mysqlimpl.PrerequisiteDao;
import src.main.java.com.solvd.university.DAO.mysqlimpl.TermDao;
import src.main.java.com.solvd.university.model.Course;
import src.main.java.com.solvd.university.model.CourseMaterial;
import src.main.java.com.solvd.university.model.Department;
import src.main.java.com.solvd.university.model.Instructor;
import src.main.java.com.solvd.university.model.Prerequisite;
import src.main.java.com.solvd.university.model.Term;
import src.main.java.com.solvd.university.service.interfaces.ICourseSerivce;

public class CourseService implements ICourseSerivce {
	private ICourseDao<Course> courseDao = new CourseDao();
	private IPrerequisiteDao<Prerequisite> prerequisiteDao = new PrerequisiteDao();
	private ICourseMaterialDao<CourseMaterial> courseMaterialDao = new CourseMaterialDao();
	private IInstructorDao<Instructor> instructorDao = new InstructorDao();
	private IDepartmentDao<Department> departmentDao = new DepartmentDao();
	private ITermDao<Term> termDao = new TermDao();
	private static final Logger log = LogManager.getLogger(CourseService.class.getName());

	@Override
	public Course getCourseById(long id) {
		Course c = null;

		try {
			c = courseDao.readEntity(id);
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		c.setPrerequisits(prerequisiteDao.getPrerequisiteById(id));
		c.setCourseMaterials(courseMaterialDao.getCourseMaterialById(id));
		c.setInstructors(instructorDao.getInstructorById(id));
		c.setTermId(termDao.getTermById(id));
		c.setDepartments(departmentDao.getDepartmentById(id));
		return c;
	}

}
