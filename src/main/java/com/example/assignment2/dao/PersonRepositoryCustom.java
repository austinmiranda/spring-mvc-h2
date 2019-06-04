/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.assignment2.dao;

import com.example.assignment2.entities.Person;
import java.util.List;

/**
 *
 * @author Austin
 */
public interface PersonRepositoryCustom {
    
    List<Person> searchByName(String name);
    
}
