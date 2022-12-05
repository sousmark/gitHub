package com.example.demo;

import java.text.NumberFormat.Style;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin(origins = "*")
public class StudentController {
	@Autowired
	private StudentRepository studentRepo;

	// Trouver la liste des étudiants
	@GetMapping("/student/all/")
	public Iterable<Student> getAllStudents() {
		return studentRepo.findAll();
	}

	// Trouver un étudiant par son ID
	@GetMapping("/student/{id}/")
	public Student studentById(@PathVariable("id") Long id) {
		Optional<Student> optStudent = studentRepo.findById(id);
		if (optStudent.isPresent()) {
			return optStudent.get();
			// return new ResponseEntity<>(optStudent.get(), HttpStatus.OK);
		}
		return null;
		// return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	// Ajouter un nouvel étudiant
	@PostMapping("/student/")
	public Student addStudent(@RequestBody Student student) {
		return studentRepo.save(student);
	}

	// Remplacer un étudiant
	@PutMapping("/student/{id}")
	public Student putStudent(@RequestBody Student student, @PathVariable("id") Long id) {
		student.setId(id);
		return studentRepo.save(student);
	} // Modifier des infos d’un étudiant

	@PatchMapping("/student/{id}")
	public Student patchStudent(@RequestBody Student patch, @PathVariable("id") Long id) {
		Student student = studentRepo.findById(id).get();
		if (patch.getName() != null) {
			student.setName(patch.getName());
		}
		if (patch.getBirthDate() != null) {
			student.setBirthDate(patch.getBirthDate());
		}
		if (patch.getEmail() != null) {
			student.setEmail(patch.getEmail());
		}
		if (patch.getDepartment() != null) {
			student.setDepartment(patch.getDepartment());
		}
		return studentRepo.save(student);
	} // Supprimer un étudiant

	@DeleteMapping("/student/{id}")
	public void deleteStudent(@PathVariable("id") Long id) {
		try {
			studentRepo.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
		}
	}
}
