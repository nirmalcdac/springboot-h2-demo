package com.nirmal.springbooth2demo.controller;

import com.nirmal.springbooth2demo.service.AssignmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/assignment")
public class AssignmentController {
    @Autowired
    private final AssignmentServiceImpl assignmentService;

    public AssignmentController(AssignmentServiceImpl assignmentService) {
        this.assignmentService = assignmentService;
    }


}