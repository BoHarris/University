package com.solvd.university.service;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.university.DAO.ICourseDao;
import com.solvd.university.DAO.ICourseMaterialDao;
import com.solvd.university.DAO.IDepartmentDao;
import com.solvd.university.DAO.IInstructorDao;
import com.solvd.university.DAO.IPrerequisiteDao;
import com.solvd.university.DAO.ITermDao;
import com.solvd.university.DAO.mysqlimpl.CourseDao;
import com.solvd.university.DAO.mysqlimpl.CourseMaterialDao;
import com.solvd.university.DAO.mysqlimpl.DepartmentDao;
import com.solvd.university.DAO.mysqlimpl.InstructorDao;
import com.solvd.university.DAO.mysqlimpl.PrerequisiteDao;
import com.solvd.university.DAO.mysqlimpl.TermDao;
import com.solvd.university.model.Course;
import com.solvd.university.model.CourseMaterial;
import com.solvd.university.model.Department;
import com.solvd.university.model.Instructor;
import com.solvd.university.model.Prerequisite;
import com.solvd.university.model.Term;
import com.solvd.university.service.interfaces.ICourseSerivce;
 
public class CourseService implements ICourseSerivce {
	private ICourseDao<Course> courseDao = new CourseDao();
	private IPrerequisiteDao<Prerequisite> prerequisiteDao = new PrerequisiteDao();
	private ICourseMaterialDao<CourseMaterial> courseMaterialDao = new CourseMaterialDao();
	private IInstructorDao<Instructor> instructorDao = new InstructorDao();
	private IDepartmentDao<Department> departmentDao = new DepartmentDao();
	private ITermDao<Term> termDao = new TermDao();
	private static final Logger LOG = LogManager.getLogger(CourseService.class.getName());

	@Override
	public Course getCourseById(long id) {
		Course c = null;

		try {
			c = courseDao.readEntity(id);
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}
		c.setPrerequisits(prerequisiteDao.getPrerequisiteById(id));
		c.setCourseMaterials(courseMaterialDao.getCourseMaterialById(id));
		c.setInstructors(instructorDao.getInstructorById(id));
		c.setTermId(termDao.getTermById(id));
		c.setDepartments(departmentDao.getDepartmentById(id));
		return c;
	}

}
