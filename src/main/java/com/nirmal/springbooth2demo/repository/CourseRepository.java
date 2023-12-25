package com.nirmal.springbooth2demo.repository;

import com.nirmal.springbooth2demo.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, String> {
    List<Course> findByActiveTrue();
}