package com.example.exam;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ApprenticeRepository extends CrudRepository<Apprentice, Long> {
    List<Apprentice> findByName(String name);

    List<Apprentice> findByNameStartsWith(String str);

    @Query(value = "select * from APPRENTICE where salary >= ?1 and salary <= ?2", nativeQuery = true)
    List<Apprentice> findBySalaryBetween(Long min, Long max);
}
