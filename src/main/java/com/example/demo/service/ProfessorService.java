package com.example.demo.service;

import com.example.demo.model.Course;
import com.example.demo.model.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessorService {
    @Autowired CourseService courseService;

    List<Professor> professors=new ArrayList<>();

    public List<Professor> getAllProfessors() {
        return professors;
    }

    public void createProfessor(Professor professor) {
//        professor.addCourse(new Course("SE",2));
//        professor.addCourse(new Course("Android",4));

        professors.add(professor);
    }

    public void addCourseToProfessor(String professorN, String courseN) {
        Course c=null;
        for(Course course: courseService.getAllCourses()){
            if(course.getName().equals(courseN)){
                c=course;
            }
        }
        if(c!=null){
            for (Professor professor: professors){
                if (professor.getName().equals(professorN)){
                    professor.addCourse(c);
                }
            }
        }
    }
}
