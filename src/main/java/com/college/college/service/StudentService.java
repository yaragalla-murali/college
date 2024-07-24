package com.college.college.service;

import org.springframework.stereotype.Service;

import com.college.college.dao.StudentDao;
import com.college.college.entity.Student;
import com.college.college.exception.ElementAlreadyExistException;
import com.college.college.exception.NoSuchElementException;

@Service
public class StudentService  {
	
	
	private StudentDao studentdao;
	
	
	public StudentService(StudentDao studentdao) {
		this.studentdao=studentdao;
	}

	
	public Student addStudent(Student student) {
		Student std=studentdao.findById(student.getId()).orElse(null);
		if(std!=null) {
			throw new ElementAlreadyExistException("Student with the ID : "+student.getId()+" already exist");
		}
		return studentdao.save(student);
	}

	
	public Student updateStudent(Student student) {	
		Student std=studentdao.findById(student.getId()).orElse(null);
		if(std==null) {
			throw new NoSuchElementException("The student with the ID : "+student.getId()+" does not exist");
		}
		return studentdao.save(student);
	}

	
	public Student getStudent(Integer id) {	
		Student std=studentdao.findById(id).orElse(null);
		if(std==null) {
			throw new NoSuchElementException("The student with the ID : "+id+" does not exist");
		}
		return std;
	}

	
	public String deleteStudent(Integer id) {
		Student std=studentdao.findById(id).orElse(null);
		if(std==null) {
			throw new NoSuchElementException("The student with the ID : "+id+" does not exist");
		}
		//deleteById() is a void method 
		studentdao.deleteById(id);
		return "Student with Id : "+id+" deleted successfully";
	}

}
