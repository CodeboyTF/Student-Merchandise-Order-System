package com.unimerch.unimerch.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Student_Table")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    public Student(Long id, String studNo, String name, String surname, String email) {
        this.id = id;
        this.studNo = studNo;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public Student() {
    }

    @Column(unique = true)
    String studNo;
    String name;
    String surname;
    String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudNo() {
        return studNo;
    }

    public void setStudNo(String studNo) {
        this.studNo = studNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //        @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
//        @JoinColumn(name = "student_id", referencedColumnName = "id")
//        List<Orders> orders;

}
