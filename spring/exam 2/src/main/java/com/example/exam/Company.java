package com.example.exam;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

//Q2 creation de l entite COMPANY pour la creation et la gestion de la base

//Q3 ajout des modifications necessaires pour faire persister les objets (@Entity, @Id, @GeneratedValue, @OneToMany...)
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String city;

    private String domain;
    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Apprentice> apprentices;

    public List<Apprentice> getApprentices() {
        return apprentices;
    }

    public void setApprentices(List<Apprentice> apprentices) {
        this.apprentices = apprentices;
    }

    public Company() {

    }

    public Company(String name, String city, String domain) {
        this.name = name;
        this.city = city;
        this.domain = domain;
        this.apprentices = apprentices;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}