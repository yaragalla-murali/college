package com.college.service;

import com.college.repository.TeacherRepository;
import com.college.entity.Teacher;
import com.college.exception.NoSuchRecordException;
import com.college.exception.RecordAlreadyExistException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {


    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }


    public Teacher addTeacher(Teacher teacher) {

        if (teacherRepository.findById(teacher.getId()).orElse(null) != null) {
            throw new RecordAlreadyExistException("Teacher with the ID : " + teacher.getId() + " already exist");
        }
        return teacherRepository.save(teacher);
    }


    public Teacher updateTeacher(Teacher teacher) {

        if (teacherRepository.findById(teacher.getId()).orElse(null) == null) {
            throw new NoSuchRecordException("Teacher with the ID : " + teacher.getId() + " does not exist");
        }
        return teacherRepository.save(teacher);
    }


    public Teacher getTeacher(Integer id) {
        Teacher teacher = teacherRepository.findById(id).orElse(null);
        if (teacher == null) {
            throw new NoSuchRecordException("Teacher with the ID : " + id + " does not exist");
        }
        return teacher;
    }


    public String deleteTeacher(Integer id) {
        Teacher teacher = teacherRepository.findById(id).orElse(null);
        if (teacher == null) {
            throw new NoSuchRecordException("Teacher with the ID : " + id + " does not exist");
        }
        teacherRepository.deleteById(id);
        return "Teacher with ID : " + id + " deleted successfully";
    }

    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers = teacherRepository.findAll();
        return teachers;
    }

    public String deleteAllTeachers() {
        teacherRepository.deleteAll();
        return "All Teachers deleted successfully";
    }

}
