package com.college.college.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.college.college.dao.StudentDao;
import com.college.college.entity.Student;
import com.college.college.exception.RecordAlreadyExistException;
import com.college.college.exception.NoSuchRecordException;

@Service
public class StudentService  {
	
	
	private StudentDao studentdao;
	
	
	public StudentService(StudentDao studentdao) {
		this.studentdao=studentdao;
	}

	
	public Student addStudent(Student student) {
		
		if(studentdao.findById(student.getId()).orElse(null)!=null) {
			throw new RecordAlreadyExistException("Student with the ID : "+student.getId()+" already exist");
		}
		
		return studentdao.save(student);
	}

	
	public Student updateStudent(Student student) {	
		
		if(studentdao.findById(student.getId()).orElse(null)==null) {
			throw new NoSuchRecordException("The student with the ID : "+student.getId()+" does not exist");
		}
		return studentdao.save(student);
	}

	
	public Student getStudent(Integer id) {	
		Student student=studentdao.findById(id).orElse(null);
		if(student==null) {
			throw new NoSuchRecordException("The student with the ID : "+id+" does not exist");
		}
		return student;
	}

	
	public String deleteStudent(Integer id) {
		Student student=studentdao.findById(id).orElse(null);
		if(student==null) {
			throw new NoSuchRecordException("The student with the ID : "+id+" does not exist");
		}
		//deleteById() is a void method 
		studentdao.deleteById(id);
		return "Student with Id : "+id+" deleted successfully";
	}
	
	public List<Student> getAllStudents(){
		List<Student> students=studentdao.findAll();
		return students;
	}
	
	public String deleteAllStudents() {
		studentdao.deleteAll();
		return "All Students deleted successfully"; 
	}

}
