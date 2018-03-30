/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.hibernatexml.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author naimish
 */
@Entity
@Table(name = "student")
public class Student {
    
    @Id @GeneratedValue
   private  int id;
   private  String name;

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
    
//     @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id")
//     private StudentDetails studentDetails;
//
//    public StudentDetails getStudentDetails() {
//        return studentDetails;
//    }
//
//    public void setStudentDetails(StudentDetails studentDetails) {
//        this.studentDetails = studentDetails;
//    }
}
