/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.spring;

/**
 *
 * @author naimish
 */
public class Student {

    private Book book;
    private int id;
    static int count = 0;
    
    public void init(){
        System.out.println("Init call");
    }
    
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student() {
        count++;
        System.out.println("Construct");
    }

    public Student(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void displayInfo() {
        System.out.println("Hello: " + name + "count is" + count);
    }
     public void destroy(){
        System.out.println("Destroy call");
    }
}
