package com.college.college.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.college.controller.dao.StudentDao;
import com.college.college.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao studentdao;

	@Override
	public String addStudent(Student student) {
		studentdao.save(student);
		return "Student Saved Successfully";
	}

	@Override
	public String updateStudent(Student student) {
		studentdao.save(student);
		return "Student updated Successfully";
	}

	@Override
	public Student getStudent(Integer id) {		
		return studentdao.findById(id).get();
	}

	@Override
	public String deleteStudent(Integer id) {
		studentdao.deleteById(id);
		return "Student with Id : "+id+" deleted successfully";
	}

}
