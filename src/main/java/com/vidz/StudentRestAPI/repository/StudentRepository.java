package com.vidz.StudentRestAPI.repository;

import com.vidz.StudentRestAPI.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {

}
