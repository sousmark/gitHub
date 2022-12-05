package com.example.demo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

	@Autowired
	private StudentRepository studentRepo;
	
	@GetMapping("/")
	public String showStudentForm(Student student) {
		return "form"; // Renvoyer la page d’inscription 
	}
	
	@PostMapping("/student")
	public String checkStudentInfo(@Valid Student student, Errors errors) {
		if (errors.hasErrors()) {
			return "form"; // Renvoyer la page d’inscription en cas d’erreur
		}
		studentRepo.save(student);
		return "redirect:/student/list"; // Afficher la liste d’étudiants
	}
	
	@GetMapping("/student/list")
	public String showStudents(Model model) {
	    model.addAttribute("students", studentRepo.findAll());
	    return "students";
	}
	
	@GetMapping("/student/list/esme")
	public String showStudentsESME(Model model) {
	    model.addAttribute("students", studentRepo.findEsmeStudents());
	    return "students";
	}
	
	@GetMapping("/student")
	public String showStudentsPrefixe(@RequestParam(required = false) String prefixe, Model model) {
	    model.addAttribute("students", studentRepo.findStudentsPrefixe(prefixe));
	    return "students";
	}
}
