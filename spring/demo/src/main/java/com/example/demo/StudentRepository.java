package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends CrudRepository<Student, Long>{
	
	@Query(value = "select * from STUDENT where email LIKE '%@esme.fr'", nativeQuery = true) 
	List<Student> findEsmeStudents();
	
	@Query(value = "select * from STUDENT where name LIKE ?%", nativeQuery = true) 
	List<Student> findStudentsPrefixe(@Param("prefixe") String prefixe);
}
