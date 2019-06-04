/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.assignment2;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author Austin
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer{
    
     @Override
     public void addViewControllers(ViewControllerRegistry registry) {
        
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/insert").setViewName("insert");
        registry.addViewController("/search").setViewName("search");     
        registry.addViewController("/edit").setViewName("edit");
    }
}
