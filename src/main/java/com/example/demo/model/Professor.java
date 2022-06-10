package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Professor {
    private String name;
    private String lName;
    private List<Course> courseList;

    public Professor(String name, String lName) {
        this.name = name;
        this.lName = lName;
        courseList=new ArrayList<>();
    }

//    public Professor(String name, String lName, List<Course> courseList) {
//        this.name = name;
//        this.lName = lName;
//        this.courseList = courseList;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public void addCourse(Course course){
        this.courseList.add(course);
    }
}
