package com.nirmal.springbooth2demo.repository;

import com.nirmal.springbooth2demo.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, String> {
    List<Assignment> findByActiveTrue();
}