package com.nirmal.springbooth2demo.repository;

import com.nirmal.springbooth2demo.model.StudentAssignmentMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SAMRepository extends JpaRepository<StudentAssignmentMapping, String> {
    List<StudentAssignmentMapping> findByActiveTrue();
}