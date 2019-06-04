/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.assignment2.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Austin
 */
@Entity
@DiscriminatorValue("Student")
public class Student extends Person {
	
    public Student(){
        
    }
    
    public Student(String name, String address, String phone, String email) {
        super(name,address,phone,email);
    }

	@Override
	public String toString() {
		return String.format("Student [id=%s, name=%s]", super.getId(), super.getName());
	}

}
