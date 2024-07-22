package com.college.college.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.envers.Audited;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
@Audited
public class Student {

	@Id
	private int id;
	private String name;
	
	@ManyToMany(mappedBy = "students")
	private List<Class> collegeClasses=new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Class> getCollegeClasses() {
		return collegeClasses;
	}

	public void setCollegeClasses(List<Class> collegeClasses) {
		this.collegeClasses = collegeClasses;
	}
	
	
}
