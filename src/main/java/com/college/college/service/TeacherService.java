package com.college.college.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.college.college.dao.TeacherDao;
import com.college.college.entity.Teacher;
import com.college.college.exception.RecordAlreadyExistException;
import com.college.college.exception.NoSuchRecordException;

@Service
public class TeacherService{

	
	private TeacherDao teacherDao;
	
	public TeacherService(TeacherDao teacherDao) {
		this.teacherDao=teacherDao;
	}
	
	
	public Teacher addTeacher(Teacher teacher) {
		
		if(teacherDao.findById(teacher.getId()).orElse(null)!=null) {
			throw new RecordAlreadyExistException("Teacher with the ID : "+teacher.getId()+" already exist");
		}
		return teacherDao.save(teacher) ;
	}
	
	
	public Teacher updateTeacher(Teacher teacher) {	
		
		if(teacherDao.findById(teacher.getId()).orElse(null)==null) {
			throw new NoSuchRecordException("Teacher with the ID : "+teacher.getId()+" does not exist");
		}
		return teacherDao.save(teacher);
	}

	
	public Teacher getTeacher(Integer id) {	
		Teacher teacher=teacherDao.findById(id).orElse(null);
		if(teacher==null) {
			throw new NoSuchRecordException("Teacher with the ID : "+id+" does not exist");
		}
		return teacher;
	}

	
	public String deleteTeacher(Integer id) {
		Teacher teacher=teacherDao.findById(id).orElse(null);
		if(teacher==null) {
			throw new NoSuchRecordException("Teacher with the ID : "+id+" does not exist");
		}
		teacherDao.deleteById(id);
		return "Teacher with ID : "+id+" deleted successfully";
	}
	
	public List<Teacher> getAllTeachers(){
		List<Teacher> teachers=teacherDao.findAll();
		return teachers;
	}
	
	public String deleteAllTeachers() {
		teacherDao.deleteAll();
		return "All Teachers deleted successfully"; 
	}

}
