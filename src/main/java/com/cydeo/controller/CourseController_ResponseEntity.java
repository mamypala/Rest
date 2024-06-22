package com.cydeo.controller;

import com.cydeo.dto.CourserDTO;
import com.cydeo.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses/api/v2")
public class CourseController_ResponseEntity {
    private final CourseService courseService;

    public CourseController_ResponseEntity(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping // ResponseEntity<> -> can pass headers, can manipulate status code
    public ResponseEntity<List<CourserDTO>> getAllCourses(){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("Version", "Cydeo.V2")
                .header("Operation", "Get List")
                .body(courseService.getCourses());
    }

    @GetMapping("{id}")
    public ResponseEntity<CourserDTO> getCourseById(@PathVariable("id") long courseId){
        return ResponseEntity.ok(courseService.getCourseById(courseId));
    }

    @GetMapping("/category/{name}")
    public ResponseEntity<List<CourserDTO>> getCourseByCategory(@PathVariable("name") String category){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("Version", "Trial V1")
                .header("Operation", "Get Category")
                .body(courseService.getCoursesByCategory(category));
    }

    @PostMapping
    public ResponseEntity<CourserDTO> createCourse(@RequestBody CourserDTO course){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Operation", "Create")
                .header("Version", "Crud trial")
                .body(courseService.createCourse(course));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCourseById(@PathVariable("id") Long courseId){
        courseService.deleteCourseById(courseId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateCourse(@PathVariable("id") Long courseId, @RequestBody CourserDTO course){
        courseService.updateCourse(courseId, course);
        return ResponseEntity.noContent().build();
    }

}
