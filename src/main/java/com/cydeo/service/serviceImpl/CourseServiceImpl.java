package com.cydeo.service.serviceImpl;

import com.cydeo.dto.CourserDTO;
import com.cydeo.entity.Course;
import com.cydeo.repository.CourseRepository;
import com.cydeo.service.CourseService;
import com.cydeo.util.MapperUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final MapperUtil mapperUtil;

    public CourseServiceImpl(CourseRepository courseRepository, MapperUtil mapperUtil) {
        this.courseRepository = courseRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public CourserDTO createCourse(CourserDTO courserDTO) {
        courseRepository.save(mapperUtil.convert(courserDTO, new Course()));
        return courserDTO;
    }

    @Override
    public CourserDTO getCourseById(long courseId) { // id ye göre course döndürüyor
        Course course = courseRepository.findById(courseId).get();
        return mapperUtil.convert(course, new  CourserDTO());
    }

    @Override
    public List<CourserDTO> getCoursesByCategory(String category) {
        List<Course> courseList = courseRepository.findAllByCategory(category);
        return courseList.stream().map(course -> mapperUtil.convert(course, new CourserDTO())).collect(Collectors.toList());
    }

    @Override
    public List<CourserDTO> getCourses() {
        List<Course> courseList = courseRepository.findAll();
        return courseList.stream().map(course -> mapperUtil.convert(course, new CourserDTO())).collect(Collectors.toList());
    }

    @Override
    public void updateCourse(Long courseId, CourserDTO courserDTO) {
        Course course = mapperUtil.convert(courserDTO, new Course());
        courseRepository.findById(courseId).ifPresent(dbCourse -> {
            dbCourse.setName(course.getName());
            dbCourse.setCategory(course.getCategory());
            dbCourse.setDescription(course.getDescription());
            dbCourse.setRating(course.getRating());
            courseRepository.save(dbCourse);
        });
    }

    @Override
    public void deleteCourseById(long courseId) {
        courseRepository.deleteById(courseId);
    }

    @Override
    public void deleteCourses() {
        courseRepository.deleteAll();
    }
}
