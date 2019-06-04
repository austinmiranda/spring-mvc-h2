/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.assignment2.controllers;

import com.example.assignment2.dao.PersonRepository;
import com.example.assignment2.entities.Employee;
import com.example.assignment2.entities.Person;
import com.example.assignment2.entities.Student;
import com.example.assignment2.viewmodels.PersonViewModel;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Austin
 */
@Controller
public class HomeController {

    @Autowired
    private PersonRepository repo;
    
    @GetMapping("/")
    public String index(Model model){
        
        //ModelAndView model = new ModelAndView();
        

        List<Person> pList = repo.findAll();
        
        for(Person p : pList){
            System.out.println(p.getName());
            
            System.out.println(p.getDecriminatorValue());
        }
       
        model.addAttribute("pList", pList);
        
        
        //model.setViewName("index");
        
        return "index";
        
    }
    
    @RequestMapping(value="/insert", method = RequestMethod.GET)
    public String insert(PersonViewModel personViewModel){
        
        
        return "insert";
        
    }
    
    @RequestMapping(value="/insert", method = RequestMethod.POST)
    public String insertP(Model model, @ModelAttribute("personViewModel") PersonViewModel personViewModel){
        
        String type = personViewModel.getType();
        String name = personViewModel.getName();
        String address = personViewModel.getAddress();
        String phone = personViewModel.getPhone();
        String email = personViewModel.getEmail();
        
        if(type.equals("Student")){
            Person s = new Student(name,address,phone,email);
            repo.save(s);
        }
        else if(type.equals("Employee")){
            Person e = new Employee(name,address,phone,email);
            repo.save(e);
        }
        else{
            Person p = new Person(name,address,phone,email);
            repo.save(p);
        }
        
        
        return "redirect:/insert";
        
    }
    @RequestMapping(value="/search", method = RequestMethod.GET)
    public String getSearch(){
        
        return "search";
        
    }
    
    @RequestMapping(value="/search", method = RequestMethod.POST)
    public String search(Model model, @RequestParam String name){
        
       List<Person> sP = repo.searchByName(name);
        
        for(Person p : sP){
            System.out.println(p.getName());
            
            System.out.println(p.getDecriminatorValue());
        }
       
        model.addAttribute("pList", sP);
        
        return "search";
        
    }
    
    @RequestMapping(value="/delete", method = RequestMethod.POST)
    public String delete(Model model, @RequestParam Long id){
        
        if(repo.existsById(id)){
            repo.deleteById(id);
        }
        return "redirect:/";
        
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(@RequestParam("id") Long id, Model model) {


            Person p = repo.getOne(id);
            if (p != null) {
                System.out.println(p.getName());
                model.addAttribute("person", p);
                return "edit";
            }
            
            return "redirect:/";
            

    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(Model model,@RequestParam("id") Long id, @RequestParam String name, 
            @RequestParam String address, @RequestParam String phone, @RequestParam String email) {

            //repo.set
            Person p = repo.getOne(id);
            if (p != null) {
                p.setName(name);
                p.setAddress(address);
                p.setPhone(phone);
                p.setEmail(email);
                repo.save(p);
                return "redirect:/";
            }
            
            return "redirect:/";
            

    }
    
}
