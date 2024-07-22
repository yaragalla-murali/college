package com.college.college.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/college")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/addStudent")
	public String addStudent(@RequestBody Student student) {
		String status=studentService.addStudent(student);
		return status;
	}
	
	@PutMapping("/updateStudent")
	public String updatetudent(@RequestBody Student student) {
		String status=studentService.updateStudent(student);
		return status;
	}
	
	@GetMapping("/getStudent/{id}")
	public Student getStudent(@PathVariable Integer id) {		
		return studentService.getStudent(id);
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable Integer id) {		
		return studentService.deleteStudent(id);
	}
}
