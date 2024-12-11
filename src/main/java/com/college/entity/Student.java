package com.college.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import org.hibernate.envers.Audited;

import java.util.List;

@Entity
@Audited
public class Student {

    @Id
    private int id;
    private String name;

    @ManyToMany(mappedBy = "students")
    private List<Class> collegeClasses;

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

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", collegeClasses=" + collegeClasses + "]";
    }


}
