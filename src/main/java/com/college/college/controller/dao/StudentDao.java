package com.college.college.controller.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.college.entity.Student;

public interface StudentDao extends JpaRepository<Student, Integer> {

}
