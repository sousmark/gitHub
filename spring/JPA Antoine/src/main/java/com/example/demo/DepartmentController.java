package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DepartmentController {
	@Autowired
	private DepartmentRepository repo;
	
	/* Liste des départements avec leurs étudiants */
	@GetMapping("/department/list/")
	public String showAllDepartments(Model model) {
		model.addAttribute("depts", repo.findAll());
		return "department-list";
	}
	
	/* Un département donnée avec ses étudiants 
	* Pour voir la liste des étudiant du département Apprentissage par exemple, tapez:
	* http://localhost:8080/department/Apprentissage/
	* */
	@GetMapping("/department/{name}/")
	public String showOneDepartment(@PathVariable("name") String name, Model model) {
		model.addAttribute("dept", repo.findByName(name));
		return "department";
	}
	
	
}
