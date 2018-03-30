/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.mavenspring.bean;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

/**
 *
 * @author naimish
 */
@Component
@Scope("prototype")
public class Dept {
    private int id;
    private String name;
    private String location;

    public Dept() {
        list = new ArrayList<Emp>();
    }

    
    public Dept(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }
    private List<Emp> list;

    public Dept(String parameter, String parameter0) {
        name = parameter;
        location = parameter0;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Emp> getList() {
        return list;
    }

    public void setList(Emp e) {
        list.add(e);
    }
    
}
