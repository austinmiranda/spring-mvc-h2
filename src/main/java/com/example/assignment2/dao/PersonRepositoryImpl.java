/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.assignment2.dao;

import com.example.assignment2.entities.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Austin
 */
@Repository
public class PersonRepositoryImpl implements PersonRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;
    
    @Override
    public List<Person> searchByName(String name) {
        Query query = entityManager.createNativeQuery("SELECT * FROM PERSON as p " +
                "WHERE upper(p.name) LIKE ?", Person.class);
        query.setParameter(1, "%"+ name.toUpperCase() + "%");
        
        return query.getResultList();
    }
    
}
