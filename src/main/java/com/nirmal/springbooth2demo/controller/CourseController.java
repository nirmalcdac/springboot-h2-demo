package com.nirmal.springbooth2demo.controller;

import com.nirmal.springbooth2demo.model.Course;
import com.nirmal.springbooth2demo.service.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CourseController {
    @Autowired
    private final CourseServiceImpl courseService;

    public CourseController(CourseServiceImpl courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/course")
    public List<Course> getAllCourse() {
        return courseService.getAllCourse();
    }
}