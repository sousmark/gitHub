package com.example.exam;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;
    /* Exercise 3 */

    /* Q4.1 */
    @GetMapping("/company/{city}/")
    public Iterable<Company> CompanyByCity(@PathVariable("city") String city) {

        return companyRepository.findByCity(city);
    }

    /* Q4.2 */
    @GetMapping("/company/{id}/apprentices")
    public Iterable<Apprentice> CompanyById(@PathVariable("id") Long id) {
        Optional<Company> optCompany = companyRepository.findById(id);
        if (optCompany.isPresent()) {
            return optCompany.get().getApprentices();
        }

        return null;
    }
}