package com.nirmal.springbooth2demo.service;


import com.nirmal.springbooth2demo.model.Instructor;

import java.util.List;

public interface InstructorService {
    List<Instructor> getAllInstructor();

    Instructor createInstructor(Instructor instructor);

    Instructor getInstructorById(String instructorId);

    Instructor updateInstructor(String instructorId, Instructor instructorDetails);

    void deleteInstructor(String instructorId);
}