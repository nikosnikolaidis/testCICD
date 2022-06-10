package com.example.demo.service;

import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Value("${gr.uom.kedivim.student.name}")
    private String defName;

    List<Student> studentsList=new ArrayList<>();

    public Student createStudent(String name,
                                String lName,
                                int age){
        Student student = new Student(defName, lName, age);
        studentsList.add(student);
        return student;
    }

    public void createStudent(Student student){
        studentsList.add(student);
    }

    public Student getStudent(String name){
        for (Student student: studentsList){
            if(student.getName().equals(name)){
                return student;
            }
        }
        return null;
    }

}
