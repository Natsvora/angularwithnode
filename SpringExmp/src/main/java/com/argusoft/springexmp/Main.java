package com.argusoft.springexmp;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author naimish
 */
public class Main {
    public static void main(String[] args) {
          ApplicationContext context = new ClassPathXmlApplicationContext("configure.xml");
          Tringle t = (Tringle)context.getBean("triangle");
          t.draw();
    }
}
