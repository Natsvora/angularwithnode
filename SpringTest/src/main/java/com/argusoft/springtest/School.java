/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.springtest;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author naimish
 */

public class School implements ApplicationEventPublisherAware{

    private int id;
    private String name;
    private  ArrayList<Student> student = null;
    private ApplicationEventPublisher publisher;    

    @PostConstruct
    public void init() {
        student = new ArrayList<Student>();
        //System.out.println("School is going throw initalization");
    }

    @PreDestroy
    public void destroy() {
        //System.out.println("School is destroy");
    }

    public List<Student> getStudent() {
        return student;
    }

    public void addStudent(Student s,ApplicationContext context,int lan) {
       CustomEvent event = new CustomEvent(this,context,lan);
        publisher.publishEvent(event);  
        student.add(s);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return student.size();
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher aep) {
        this.publisher = aep;
    }

    

}
