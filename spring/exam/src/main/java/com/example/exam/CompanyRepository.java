package com.example.exam;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, Long> {

    Optional<Company> findById(Long id);

    List<Company> findByCity(String city);

}