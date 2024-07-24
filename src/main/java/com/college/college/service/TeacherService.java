package com.college.college.service;

import org.springframework.stereotype.Service;

import com.college.college.dao.TeacherDao;
import com.college.college.entity.Teacher;
import com.college.college.exception.ElementAlreadyExistException;
import com.college.college.exception.NoSuchElementException;

@Service
public class TeacherService{

	
	private TeacherDao teacherDao;
	
	public TeacherService(TeacherDao teacherDao) {
		this.teacherDao=teacherDao;
	}
	
	
	public Teacher addTeacher(Teacher teacher) {
		Teacher _teacher=teacherDao.findById(teacher.getId()).orElse(null);
		if(_teacher!=null) {
			throw new ElementAlreadyExistException("Teacher with the ID : "+teacher.getId()+" already exist");
		}
		return teacherDao.save(teacher) ;
	}
	
	
	public Teacher updateTeacher(Teacher teacher) {	
		Teacher _teacher=teacherDao.findById(teacher.getId()).orElse(null);
		if(_teacher==null) {
			throw new NoSuchElementException("Teacher with the ID : "+teacher.getId()+" does not exist");
		}
		return teacherDao.save(teacher);
	}

	
	public Teacher getTeacher(Integer id) {	
		Teacher _teacher=teacherDao.findById(id).orElse(null);
		if(_teacher==null) {
			throw new NoSuchElementException("Teacher with the ID : "+id+" does not exist");
		}
		return _teacher;
	}

	
	public String deleteTeacher(Integer id) {
		Teacher _teacher=teacherDao.findById(id).orElse(null);
		if(_teacher==null) {
			throw new NoSuchElementException("Teacher with the ID : "+id+" does not exist");
		}
		teacherDao.deleteById(id);
		return "Teacher with ID : "+id+" deleted successfully";
	}

}
