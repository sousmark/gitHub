package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long>{
	List<Student> findByName(String name);
	List<Student> findByNameStartsWith(String prefix);
	List<Student> findByNameOrderByBirthDate(String name);
	List<Student> findByEmail(String email);
	List<Student> findByDepartment(Department department);
	
	@Query(value = "select * from STUDENT where email LIKE '%@esme.fr'", nativeQuery = true)
	List<Student> findEsmeStudents();
	
}
