package com.example.demo.service;

import com.example.demo.model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    private List<Course> courseList=new ArrayList<>();

    public List<Course> getAllCourses() {
        return courseList;
    }

    public void createCourse(Course course) {
        courseList.add(course);
    }
}
