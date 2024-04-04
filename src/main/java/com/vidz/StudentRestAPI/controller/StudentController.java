package com.vidz.StudentRestAPI.controller;

import com.vidz.StudentRestAPI.entity.Student;
import com.vidz.StudentRestAPI.repository.StudentRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentRepository repo;
    //get all students
    //localhost:8080/students
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        List<Student> students = repo.findAll();
        return students;
    }

    //get student by id
    //localhost:8080/students/id
    @GetMapping("students/{id}")
    public Student getStudent(@PathVariable int id){
        Student student = repo.findById(id).get();
        return student;
    }

}
