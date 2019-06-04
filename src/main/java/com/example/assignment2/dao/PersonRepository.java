/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.assignment2.dao;

import com.example.assignment2.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Austin
 */
@Repository
public interface PersonRepository extends JpaRepository<Person,Long>, PersonRepositoryCustom{
    
}
