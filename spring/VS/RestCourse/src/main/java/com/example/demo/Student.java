package com.example.demo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String birthDate;
	private String email;
	private Date createdAt;
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;

	@PrePersist
	void createdAt() {
		this.createdAt = new Date();
	}

	public Student(String name, String birthDate, String email) {
		this.name = name;
		this.birthDate = birthDate;
		this.email = email;
	}

	public Student() {
	}

	public Long getId() {
		return id;
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

	public void setId(Long id) {
		this.id = id;
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", email=" + email + "]";
	}

}
