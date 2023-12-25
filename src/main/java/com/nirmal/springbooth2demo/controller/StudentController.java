package com.nirmal.springbooth2demo.controller;

import com.nirmal.springbooth2demo.model.Student;
import com.nirmal.springbooth2demo.service.SAMServiceImpl;
import com.nirmal.springbooth2demo.service.SCMServiceImpl;
import com.nirmal.springbooth2demo.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
    @Autowired
    private final StudentServiceImpl studentService;
    private final SCMServiceImpl scmService;
    private final SAMServiceImpl samService;

    public StudentController(StudentServiceImpl studentService, SCMServiceImpl scmService, SAMServiceImpl samService) {
        this.studentService = studentService;
        this.scmService = scmService;
        this.samService = samService;
    }

    @GetMapping("/student")
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    @PostMapping("/student")
    public Student createUser(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getUserById(@PathVariable String userId) {
        Student student = studentService.getStudentById(userId);
        return ResponseEntity.ok(student);
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<Student> updateUser(@PathVariable String studentId, @RequestBody Student studentDetails) {
        Student student = studentService.updateStudent(studentId, studentDetails);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable String studentId) {
        studentService.deleteStudent(studentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}