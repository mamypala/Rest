package com.cydeo.service;

import com.cydeo.dto.CourserDTO;

import java.util.List;

public interface CourseService {

    CourserDTO createCourse(CourserDTO courserDTO);
    CourserDTO getCourseById(long courseId);

    List<CourserDTO> getCoursesByCategory(String category);
    List<CourserDTO> getCourses();

    void updateCourse(Long courseId, CourserDTO courserDTO);

    void deleteCourseById(long courseId);
    void deleteCourses();
}
