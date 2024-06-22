package com.cydeo.controller;

import com.cydeo.dto.CourserDTO;
import com.cydeo.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // @ResponseBody + @Controller
@RequestMapping("/courses/api/v1")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourserDTO> getAllCourses(){
        return courseService.getCourses();
    }

    @GetMapping("{id}")
    public CourserDTO getCourseById(@PathVariable("id") long courseId){
        return courseService.getCourseById(courseId);
    }

    @GetMapping("/category/{name}")
    public List<CourserDTO> getCourseByCategory(@PathVariable("name") String category){
        return courseService.getCoursesByCategory(category);
    }

    @PostMapping // RequestBody yeni oluşturulan dto daki objeyi yakalar!
    public CourserDTO createCourse(@RequestBody CourserDTO course){
        return courseService.createCourse(course);
    }

    @PutMapping("{id}")
    public void updateCourse(@PathVariable("id") long courseId, @RequestBody CourserDTO course){
        courseService.updateCourse(courseId, course);
    }

    @DeleteMapping("{id}")
    public void deleteCourseById(@PathVariable("id") long courseId){
        courseService.deleteCourseById(courseId);
    }

}
