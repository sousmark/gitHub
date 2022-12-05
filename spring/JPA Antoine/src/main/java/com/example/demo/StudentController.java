package com.example.demo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
	@Autowired
	private StudentRepository studentRepo;
	@Autowired
	DepartmentRepository departmentRepository;
	
	@GetMapping("/student/new")
	public String showStudentForm(Student student, Model model) {
		model.addAttribute("listDepartment", departmentRepository.findAll());
		return "form";
	}
	
	@PostMapping("/student/new")
	public String saveStudent(@Valid Student student, Errors errors) {
		if (errors.hasErrors()) {
			return "form";
		}
		studentRepo.save(student);
		return "redirect:/student/list";
	}
	
	@GetMapping("/student/list")
	public String showStudents(Model model) {
		model.addAttribute("students", studentRepo.findAll());
		
		return "students-page";
	}
	
	@GetMapping("/student")
	public String showStudents(@RequestParam String prefix, Model model) {
		model.addAttribute("students", studentRepo.findByNameStartsWith(prefix));
		
		return "students-page";
	}
	
	@GetMapping("/student/list/esme")
	public String showEsmeStudents(Model model) {
		model.addAttribute("students", studentRepo.findEsmeStudents());
		
		return "students-page";
	}
}
