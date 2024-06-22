package com.cydeo.service.serviceImpl;

import com.cydeo.dto.CourserDTO;
import com.cydeo.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Override
    public CourserDTO createCourse(CourserDTO courserDTO) {
        return null;
    }

    @Override
    public CourserDTO getCourseById(long courseId) {
        return null;
    }

    @Override
    public List<CourserDTO> getCoursesByCategory(String category) {
        return null;
    }

    @Override
    public List<CourserDTO> getCourses() {
        return null;
    }

    @Override
    public void updateCourse(Long courseId, CourserDTO courserDTO) {

    }

    @Override
    public void deleteCourseById(long courseId) {

    }

    @Override
    public void deleteCourses() {

    }
}
