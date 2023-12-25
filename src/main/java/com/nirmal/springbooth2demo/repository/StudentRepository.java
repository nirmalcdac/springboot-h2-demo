package com.nirmal.springbooth2demo.repository;

import com.nirmal.springbooth2demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {
    List<Student> findByActiveTrue();
}