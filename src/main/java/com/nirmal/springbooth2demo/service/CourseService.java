package com.nirmal.springbooth2demo.service;


import com.nirmal.springbooth2demo.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourse();

    Course createCourse(Course course);

    Course getCourseById(String course_id);

    Course updateCourse(String course_id, Course courseDetails);

    void deleteCourse(String course_id);
}