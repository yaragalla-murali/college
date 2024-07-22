package com.college.college.controller.service;

import com.college.college.entity.Teacher;

public interface TeacherService {

	public String addTeacher(Teacher teacher);
	public String updateTeacher(Teacher teacher);
	public Teacher getTeacher(Integer id);
	public String deleteTeacher(Integer id);
}
