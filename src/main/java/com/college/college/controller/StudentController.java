package com.college.college.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.college.controller.service.StudentService;
import com.college.college.entity.Student;

@RestController
@RequestMapping("/students")
public class StudentController {

	private StudentService studentService;
	
	public StudentController(StudentService studentService) {
		this.studentService=studentService;
	}
	
	@PostMapping
	public Student addStudent(@RequestBody Student student) {		
		return studentService.addStudent(student);
	}
	
	@PutMapping
	public Student updatetudent(@RequestBody Student student) {		
		return studentService.updateStudent(student);
	}
	
	@GetMapping("/{id}")
	public Student getStudent(@PathVariable Integer id) {		
		return studentService.getStudent(id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable Integer id) {		
		return studentService.deleteStudent(id);
	}
	
	
}
