package com.unimerch.unimerch.service;

import com.unimerch.unimerch.entity.Student;
import com.unimerch.unimerch.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

//    public Student registerStudent(String studNo, String name, String surname, String email){
//        Student student2 = new Student(studNo, name, surname, email);
//        return studentRepository.save(student2);
//    }

    public Optional<Student> findByStudNo(String studNo) {
        return studentRepository.findByStudNo(studNo);
    }
    public Student updateStudent(Long id, String name, String surname){
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if(optionalStudent.isPresent()){
            Student student = optionalStudent.get();
            student.setName(name);
            student.setSurname(surname);
            return studentRepository.save(student);
        }
        throw new RuntimeException(("ID IS NOT FOUND" + id));
    }

}
