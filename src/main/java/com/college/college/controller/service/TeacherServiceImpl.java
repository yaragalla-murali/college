package com.college.college.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.college.controller.dao.TeacherDao;
import com.college.college.entity.Teacher;

@Service
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private TeacherDao teacherDao;
	
	
	@Override
	public String addTeacher(Teacher teacher) {
		teacherDao.save(teacher);
		return "Teacher successfully Saved";
	}
	
	@Override
	public String updateTeacher(Teacher teacher) {
		teacherDao.save(teacher);
		return "Teacher updated Successfully";
	}

	@Override
	public Teacher getTeacher(Integer id) {			
		return teacherDao.findById(id).get();
	}

	@Override
	public String deleteTeacher(Integer id) {
		teacherDao.deleteById(id);
		return "Teacher with ID : "+id+" deleted successfully";
	}

}
