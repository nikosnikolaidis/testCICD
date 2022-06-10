package com.example.demo.controller;

import com.example.demo.model.Course;
import com.example.demo.model.Professor;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CoursesController {

    @Autowired
    private CourseService courseService;

    @GetMapping(path = "/course")
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }

    @PostMapping(path = "/course")
    public String createCourse(@RequestBody Course course){
        courseService.createCourse(course);
        return "Done";
    }
}
