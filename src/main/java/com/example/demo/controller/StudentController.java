package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(path = "/hello")
    public String getHello(){
        return "Hello";
    }

    @GetMapping(path = "/hello/nikos")
    public String getHelloForNikos(){
        return "Hello Nikos";
    }

    //http://localhost:8181/hello/name/Maria
    @GetMapping(path = "/hello/name/{givenName}")
    public String getHello(@PathVariable(value = "givenName") String name){
        return "Hello "+name;
    }

    //http://localhost:8181/hello/name/Maria/Papa
    @GetMapping(path = "/hello/name/{givenName}/{lastName}")
    public String getHello(@PathVariable(value = "givenName") String name,
                           @PathVariable(value = "lastName") String lname){
        return "Hello "+name+", "+lname;
    }

    //http://localhost:8181/hello/name?givenName=Maria
    @GetMapping(path = "/hello/name")
    public String getHelloParam(@RequestParam(value = "givenName") String name){
        return "Hello "+name;
    }

    //http://localhost:8181/hello/withlastname?givenName=Maria&lastName=Papa
    @GetMapping(path = "/hello/withlastname")
    public String getHelloParam(@RequestParam(value = "givenName") String name,
                                @RequestParam(value = "lastName", required = false) String lname){
        return "Hello "+name+", "+lname;
    }


    //http://localhost:8181/hello/student?name=Nikos&lname=Nikolaidis&age=27
    @GetMapping(path = "/hello/student")
    public Student getStudent(@RequestParam(value = "name") String name,
                              @RequestParam(value = "lname") String lname,
                              @RequestParam(value = "age") int age){
        return studentService.createStudent(name,lname,age);
    }


    @PostMapping(path = "/student")
    public String addStudent(@RequestBody Student student){
        studentService.createStudent(student);
        return "Student created!";
    }

    @GetMapping(path = "/student")
    public Student getStudent(@RequestParam(value = "name") String name){
        return studentService.getStudent(name);
    }


    /*
    Professor
        name, lastName, List<Courses>

    Course
        name, yearNumber

    createCourse
    getCourses

    createProfessor
    getProfessors
    */

}
