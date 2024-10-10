package com.unimerch.unimerch.controller;

import com.unimerch.unimerch.entity.Student;
import com.unimerch.unimerch.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PutMapping("/update/student/{id}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable Long id,
            @RequestBody Student student){
        Student student1 = studentService.updateStudent(id, student.getName(),student.getSurname());
        return ResponseEntity.ok(student1);
    }

}
