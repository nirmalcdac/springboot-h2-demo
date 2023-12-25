package com.nirmal.springbooth2demo.service;

import com.nirmal.springbooth2demo.exception.ResourceNotFoundException;
import com.nirmal.springbooth2demo.model.Course;
import com.nirmal.springbooth2demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findByActiveTrue();
    }

    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course getCourseById(String course_id) {
        return courseRepository.findById(course_id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found for given id" + course_id));
    }

    @Override
    public Course updateCourse(String course_id, Course courseDetails) {
        Course updateCourse = courseRepository.findById(course_id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found for given id" + course_id));
        updateCourse.setCourseName(courseDetails.getCourseName());
        updateCourse.setCreatedBy(courseDetails.getCreatedBy());
        updateCourse.setUpdatedBy(courseDetails.getUpdatedBy());
        updateCourse.setCreatedAt(courseDetails.getCreatedAt());
        updateCourse.setUpdatedAt(courseDetails.getUpdatedAt());
        updateCourse.setActive(courseDetails.getActive());
        courseRepository.save(updateCourse);
        return updateCourse;
    }

    @Override
    public void deleteCourse(String course_id) {
        Course deleteCourse = courseRepository.findById(course_id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found for given id" + course_id));
        deleteCourse.setActive(false);
        courseRepository.save(deleteCourse);
    }
}