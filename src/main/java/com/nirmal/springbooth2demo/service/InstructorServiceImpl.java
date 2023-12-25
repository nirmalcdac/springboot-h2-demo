package com.nirmal.springbooth2demo.service;

import com.nirmal.springbooth2demo.exception.ResourceNotFoundException;
import com.nirmal.springbooth2demo.model.Instructor;
import com.nirmal.springbooth2demo.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {
    @Autowired
    private final InstructorRepository instructorRepository;

    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }


    @Override
    public List<Instructor> getAllInstructor() {
        return instructorRepository.findByActiveTrue();
    }

    @Override
    public Instructor createInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor getInstructorById(String instructorId) {
        return instructorRepository.findById(instructorId)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor not found for given id" + instructorId));
    }

    @Override
    public Instructor updateInstructor(String instructorId, Instructor instructorDetails) {
        Instructor updateInstructor = instructorRepository.findById(instructorId)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor not found for given id" + instructorId));
        updateInstructor.setInstructorFirstName(instructorDetails.getInstructorFirstName());
        updateInstructor.setInstructorFirstName(instructorDetails.getInstructorLastName());
        updateInstructor.setAppUser(instructorDetails.getAppUser());
        updateInstructor.setCreatedBy(instructorDetails.getCreatedBy());
        updateInstructor.setUpdatedBy(instructorDetails.getUpdatedBy());
        updateInstructor.setCreatedAt(instructorDetails.getCreatedAt());
        updateInstructor.setUpdatedAt(instructorDetails.getUpdatedAt());
        updateInstructor.setActive(instructorDetails.getActive());
        instructorRepository.save(updateInstructor);
        return updateInstructor;
    }

    @Override
    public void deleteInstructor(String instructorId) {
        Instructor deleteInstructor = instructorRepository.findById(instructorId)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor not found for given id" + instructorId));
        deleteInstructor.setActive(false);
        instructorRepository.save(deleteInstructor);
    }
}