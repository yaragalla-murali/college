package com.college.college.controller.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.college.entity.Teacher;

public interface TeacherDao extends JpaRepository<Teacher, Integer> {

}
