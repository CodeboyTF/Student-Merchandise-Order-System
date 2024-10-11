package com.unimerch.unimerch.repository;

import com.unimerch.unimerch.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByStudNo(String studNo);
}

