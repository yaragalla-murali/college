package com.college.college.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.college.entity.Teacher;
import com.college.college.service.TeacherService;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
	
	
	private TeacherService teacherService;
	
	public TeacherController(TeacherService teacherService) {
		this.teacherService=teacherService;
	}
	
	@PostMapping
	public Teacher addTeacher(@RequestBody Teacher teacher) {		
		return teacherService.addTeacher(teacher);
	}
	
	@PutMapping
	public Teacher updateTeacher(@RequestBody Teacher teacher) {		
		return teacherService.updateTeacher(teacher);
	}
	
	@GetMapping("/{id}")
	public Teacher getTeacher(@PathVariable Integer id) {		
		return teacherService.getTeacher(id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteTeacher(@PathVariable Integer id) {		
		return teacherService.deleteTeacher(id);
	}
	
	

}
