/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.spring;

import java.util.List;

/**
 *
 * @author naimish
 */
public class Class {
    private int id;
    private List<Student> list;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }
    
    public void setStudent(Student s)
    {
        list.add(s);
    }
}
