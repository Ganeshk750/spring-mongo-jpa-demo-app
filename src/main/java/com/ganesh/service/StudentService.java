package com.ganesh.service;


import com.ganesh.models.Student;
import com.ganesh.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @created: 20/09/2021 - 1:35 PM
 * @author: Ganesh
 */

@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents(){
      return  studentRepository.findAll();
    }
}
