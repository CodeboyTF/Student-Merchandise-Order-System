package com.unimerch.unimerch.service;

import com.unimerch.unimerch.entity.Student;
import com.unimerch.unimerch.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

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

    public void updateStudentPassword(Long id, String newPassword) {
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            String encodedPassword = passwordEncoder.encode(newPassword);
            student.setPassword(encodedPassword);
            studentRepository.save(student);
        } else {
            throw new RuntimeException("ID NOT FOUND: " + id);
        }
    }
}
