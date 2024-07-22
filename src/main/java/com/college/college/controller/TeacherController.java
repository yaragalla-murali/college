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

import com.college.college.controller.service.TeacherService;
import com.college.college.entity.Teacher;

@RestController
@RequestMapping("/college")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	@PostMapping("/addTeacher")
	public String addTeacher(@RequestBody Teacher teacher) {
		String status=teacherService.addTeacher(teacher);
		return status;
	}
	
	@PutMapping("/updateTeacher")
	public String updateTeacher(@RequestBody Teacher teacher) {
		String status=teacherService.updateTeacher(teacher);
		return status;
	}
	
	@GetMapping("/getTeacher/{id}")
	public Teacher getTeacher(@PathVariable Integer id) {		
		return teacherService.getTeacher(id);
	}
	
	@DeleteMapping("/deleteTeacher/{id}")
	public String deleteTeacher(@PathVariable Integer id) {		
		return teacherService.deleteTeacher(id);
	}
	
	

}
