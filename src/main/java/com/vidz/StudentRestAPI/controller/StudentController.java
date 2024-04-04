package com.vidz.StudentRestAPI.controller;

import com.vidz.StudentRestAPI.entity.Student;
import com.vidz.StudentRestAPI.repository.StudentRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    //add new student
    @PostMapping("/student/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addStudent(@RequestBody Student student){
        repo.save(student).getName();

    }

    //update student details
    //localhost:8080/student/update/id
    @PutMapping("/student/update/{id}")
    public Student updateStudent(@PathVariable int id){
        Student student = repo.findById(id).get();
        student.setName("pasan");
        repo.save(student);
        return student;
    }

    //delete student
    //localhost:8080/student/delete/id
    @DeleteMapping("/student/delete/{id}")
    public void deleteStudent(@PathVariable int id){
        Student student = repo.findById(id).get();
        repo.delete(student);
    }

}
