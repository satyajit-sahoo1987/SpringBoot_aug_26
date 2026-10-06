package com.example.examination_system.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String rollNumber;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Student() {
    }

    public Student(String name, String email, String rollNumber) {
        this.name = name;
        this.email = email;
        this.rollNumber = rollNumber;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public Department getDepartment() {
        return department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}