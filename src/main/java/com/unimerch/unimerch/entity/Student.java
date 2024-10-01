package com.unimerch.unimerch.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Student_Table")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long stud_id;

    @Column(unique = true)
    String stud_no;
    String stud_name;
    String stud_surname;
    String stud_email;


//        @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
//        @JoinColumn(name = "student_id", referencedColumnName = "id")
//        List<Orders> orders;

}
