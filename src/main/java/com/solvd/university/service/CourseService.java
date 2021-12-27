package com.solvd.university.service;

import java.util.List;

import com.solvd.university.DAO.ICourseDao;
import com.solvd.university.DAO.ICourseMaterialDao;
import com.solvd.university.DAO.IInstructorDao;
import com.solvd.university.DAO.IPrerequisiteDao;
import com.solvd.university.DAO.mysqlimpl.CourseDao;
import com.solvd.university.DAO.mysqlimpl.CourseMaterialDao;
import com.solvd.university.DAO.mysqlimpl.InstructorDao;
import com.solvd.university.DAO.mysqlimpl.PrerequisiteDao;
import com.solvd.university.model.Course;
import com.solvd.university.service.interfaces.ICourseSerivce;

public class CourseService implements ICourseSerivce {
	private ICourseDao courseDao = new CourseDao();
	private IPrerequisiteDao prerequisiteDao = new PrerequisiteDao();
	private ICourseMaterialDao courseMaterialDao = new CourseMaterialDao();
	private IInstructorDao instructorDao = new InstructorDao();

	@Override
	public Course getCourseById(long id) {
		Course c = courseDao.getCourseById(id);
		c.setPrerequisits(prerequisiteDao.getListedPrerequisiteById(id));

		return c;

	}

}
