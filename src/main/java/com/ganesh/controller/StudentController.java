package com.ganesh.controller;


import com.ganesh.models.Student;
import com.ganesh.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @created: 20/09/2021 - 1:33 PM
 * @author: Ganesh
 */


@RestController
@RequestMapping("api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    List<Student> fetchStucents(){
      return studentService.getAllStudents();
    }
}
