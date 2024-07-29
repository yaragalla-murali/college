package com.college.college.entity;

import java.util.List;

import org.hibernate.envers.Audited;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
@Audited
public class Classroom {

	@Id	
	private String name;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	private List<Class> classes;

	

	public List<Class> getClasses() {
		return classes;
	}

	public void setClasses(List<Class> classes) {
		this.classes = classes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Classroom [name=" + name + ", classes=" + classes + "]";
	}

	
}
