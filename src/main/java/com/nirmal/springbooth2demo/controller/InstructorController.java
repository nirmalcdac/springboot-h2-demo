package com.nirmal.springbooth2demo.controller;

import com.nirmal.springbooth2demo.model.Instructor;
import com.nirmal.springbooth2demo.service.InstructorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class InstructorController {
    @Autowired
    private final InstructorServiceImpl instructorService;

    public InstructorController(InstructorServiceImpl instructorService) {
        this.instructorService = instructorService;
    }


    @GetMapping("/instructor")
    public List<Instructor> getAllInstructors() {
        return instructorService.getAllInstructor();
    }

    @PostMapping("/instructor")
    public Instructor createInstructor(@RequestBody Instructor instructor) {
        return instructorService.createInstructor(instructor);
    }

    @GetMapping("/instructor/{id}")
    public ResponseEntity<Instructor> getInstructorById(@PathVariable String instructorId) {
        Instructor instructor = instructorService.getInstructorById(instructorId);
        return ResponseEntity.ok(instructor);
    }

    @PutMapping("/instructor/{id}")
    public ResponseEntity<Instructor> updateInstructor(@PathVariable String instructorId, @RequestBody Instructor instructorDetails) {
        Instructor instructor = instructorService.updateInstructor(instructorId, instructorDetails);
        return ResponseEntity.ok(instructor);
    }

    @DeleteMapping("/instructor/{id}")
    public ResponseEntity<HttpStatus> deleteInstructor(@PathVariable String instructorId) {
        instructorService.deleteInstructor(instructorId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}