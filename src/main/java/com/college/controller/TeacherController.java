package com.college.controller;

import com.college.entity.Teacher;
import com.college.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {


    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
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

    @GetMapping("/getAll")
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @DeleteMapping("/deleteAll")
    public String deleteAllTeachers() {
        return teacherService.deleteAllTeachers();
    }


}
