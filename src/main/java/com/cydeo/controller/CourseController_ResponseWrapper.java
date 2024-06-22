package com.cydeo.controller;

import com.cydeo.dto.ResponseWrapper;
import com.cydeo.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses/api/v3") // Artık ResponseWrapper ile API oluşturulacak!
public class CourseController_ResponseWrapper { // ResponseWrapper sınıfı ile özelleştirilmiş obje oluşumu...
    private final CourseService courseService;

    public CourseController_ResponseWrapper(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getAllCourses(){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("Version", "Wrapper Trial")
                .body(new ResponseWrapper("Courses successfully retrieved", courseService.getCourses()));
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseWrapper> getCoursesById(@PathVariable("id") long courseId){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("Operation", "Getting Courses By Id")
                .header("Version", "Trial")
                .body(new ResponseWrapper("Course: "+ courseId + " retrieved", courseService.getCourseById(courseId)));
    }
}
