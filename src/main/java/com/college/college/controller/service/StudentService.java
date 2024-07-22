package com.college.college.controller.service;

import com.college.college.entity.Student;

public interface StudentService {

	public String addStudent(Student student);
	public String updateStudent(Student student);
	public Student getStudent(Integer id);
	public String deleteStudent(Integer id);
}
