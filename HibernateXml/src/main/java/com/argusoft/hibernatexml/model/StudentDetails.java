/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.hibernatexml.model;

import com.sun.javafx.beans.IDProperty;
import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author naimish
 */
@Entity
@Table(name = "student_details")
public class StudentDetails {

    @Id
    @GeneratedValue(generator = "newGenerator")
    @GenericGenerator(name = "newGenerator",strategy = "foreign",parameters = {@Parameter(value ="student",name = "property" )})
   // @GeneratedValue
    private int id;

    private String mobileno;

    @OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "id")
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }
}
