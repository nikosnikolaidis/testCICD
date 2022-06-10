package com.example.demo.controller;

import com.example.demo.model.Professor;
import com.example.demo.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping(path = "/professors")
    public List<Professor> getProfessor(){
        return professorService.getAllProfessors();
    }

    @PostMapping(path = "/professors")
    public String createProfessor(@RequestBody Professor professor){
        professorService.createProfessor(professor);
        return "Done";
    }

    @PostMapping(path = "/addcoursetoprofessors")
    public String addCourseToProfessor(@RequestParam(value = "pname") String professorN,
                                       @RequestParam(value = "cname") String courseN){
        professorService.addCourseToProfessor(professorN, courseN);
        return "Done";
    }
}
