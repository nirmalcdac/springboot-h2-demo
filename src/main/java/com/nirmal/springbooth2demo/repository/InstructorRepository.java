package com.nirmal.springbooth2demo.repository;

import com.nirmal.springbooth2demo.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstructorRepository extends JpaRepository<Instructor, String> {
    List<Instructor> findByActiveTrue();
}