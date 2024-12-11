package com.college.service;

import com.college.repository.StudentRepository;
import com.college.entity.Student;
import com.college.exception.NoSuchRecordException;
import com.college.exception.RecordAlreadyExistException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {


    private final StudentRepository studentdao;


    public StudentService(StudentRepository studentdao) {
        this.studentdao = studentdao;
    }


    public Student addStudent(Student student) {

        if (studentdao.findById(student.getId()).orElse(null) != null) {
            throw new RecordAlreadyExistException("Student with the ID : " + student.getId() + " already exist");
        }

        return studentdao.save(student);
    }


    public Student updateStudent(Student student) {

        if (studentdao.findById(student.getId()).orElse(null) == null) {
            throw new NoSuchRecordException("The student with the ID : " + student.getId() + " does not exist");
        }
        return studentdao.save(student);
    }


    public Student getStudent(Integer id) {
        Student student = studentdao.findById(id).orElse(null);
        if (student == null) {
            throw new NoSuchRecordException("The student with the ID : " + id + " does not exist");
        }
        return student;
    }


    public String deleteStudent(Integer id) {
        Student student = studentdao.findById(id).orElse(null);
        if (student == null) {
            throw new NoSuchRecordException("The student with the ID : " + id + " does not exist");
        }
        //deleteById() is a void method
        studentdao.deleteById(id);
        return "Student with Id : " + id + " deleted successfully";
    }

    public List<Student> getAllStudents() {
        List<Student> students = studentdao.findAll();
        return students;
    }

    public String deleteAllStudents() {
        studentdao.deleteAll();
        return "All Students deleted successfully";
    }

}
