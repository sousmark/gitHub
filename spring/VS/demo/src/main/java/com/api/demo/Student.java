package com.api.demo;

import java.util.Date;

public class Student {
    private Long id;
    private String name;
    private String birthDate;
    private String email;
    private Date createdAt;
    private Department department;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student(Long id, String name, String birthDate, String email, Date createdAt, Department department) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
        this.createdAt = createdAt;
        this.department = department;
    }

    public Student(Long id, String name, String birthDate, String email) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
    }

    public Student(String name, String birthDate, String email) {
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Department getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", email=" + email + "]";
    }

}
