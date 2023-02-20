package com.example.exam;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "")
@CrossOrigin(origins = "*")
public class ApprenticeController {

    @Autowired
    private ApprenticeRepository apprenticeRepository;

    // Q4 1. Trouver un apprenti avec un id donnee
    @GetMapping("/apprentice/{id}/")
    public Apprentice getApprenticeById(@PathVariable("id") Long id) {
        Optional<Apprentice> optApprentice = apprenticeRepository.findById(id);
        if (optApprentice.isPresent()) {
            return optApprentice.get();
        }
        return null;
    }

    // Q4 2. Trouver la liste des apprentis
    @GetMapping("/apprentice/all/")
    public Iterable<Apprentice> getAllApprentices() {
        return apprenticeRepository.findAll();
    }

    // Q4 3. Trouver la liste des apprentis avec un nom donnee
    @GetMapping("/apprentice/name/{name}/")
    public Iterable<Apprentice> getApprenticeByName(@PathVariable("name") String name) {
        return apprenticeRepository.findByName(name);
    }

    // Q4 4. Trouver la liste des apprentis avec une partie du nom donnee
    @GetMapping("/apprentice/like/{str}/")
    public Iterable<Apprentice> getApprenticeByNameLike(@PathVariable("str") String str) {
        return apprenticeRepository.findByNameStartsWith(str);
    }

    // Q4 5. Trouver la liste des apprentis avec salaire compris entre deux valeurs
    @GetMapping("/apprentice/salary/{min}/{max}/")
    public Iterable<Apprentice> getApprenticeBySalaryBetween(@PathVariable("min") Long min,
            @PathVariable("max") Long max) {
        return apprenticeRepository.findBySalaryBetween(min, max);
    }

    // Q4 6. Ajouter un nouvel apprenti
    @PostMapping("/apprentice/new/")
    public Apprentice addApprentice(@RequestBody Apprentice apprentice) {
        return apprenticeRepository.save(apprentice);
    }

    // Q4 7. Supprimer un apprenti
    @DeleteMapping("/apprentice/{id}/")
    public void deleteApprentice(@PathVariable("id") Long id) {
        try {
            apprenticeRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }

    // Q4 8. Remplacer un apprenti
    @PutMapping("/apprentice/{id}/")
    public Apprentice putApprentice(@RequestBody Apprentice apprentice, @PathVariable("id") Long id) {
        apprentice.setId(id);
        return apprenticeRepository.save(apprentice);
    }
}
