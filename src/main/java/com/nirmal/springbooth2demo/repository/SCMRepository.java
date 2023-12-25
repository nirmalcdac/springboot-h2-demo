package com.nirmal.springbooth2demo.repository;

import com.nirmal.springbooth2demo.model.StudentCourseMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SCMRepository extends JpaRepository<StudentCourseMapping, String> {
    List<StudentCourseMapping> findByActiveTrue();
}