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
import java.util.Iterator;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Test {

    public static void main(String[] args) {
//      with factoryBean
//        Resource resource = new ClassPathResource("Config.xml");
//        BeanFactory factory = new XmlBeanFactory(resource);
//        Student stu dent = (Student) factory.getBean("Student");


//  with context
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("Config.xml");
//        Student student = (Student) context.getBean("Student");
//        student.displayInfo();
        //student.displayInfo();
        
//  with constructor
//        Student student = (Student) context.getBean("StudentConstructor");
//        student.displayInfo();
        
//  with object
//        Student student = (Student) context.getBean("Book");
//        System.out.println(student.getBook().getName());
// 
//    Class c = (Class)context.getBean("Class");
//    Iterator<Student> itr=c.getList().iterator();
//    while(itr.hasNext()){  
//        Student s = itr.next();
//        System.out.println(s.getId() +" "+s.getName());  

//     Student student = (Student) context.getBean("Student");
//        student.displayInfo();
//        student = (Student) context.getBean("Student");
//        student.displayInfo();
//        student = (Student) context.getBean("Student");
//        student.displayInfo();
{
        Student student = (Student) context.getBean("Student");
        student.displayInfo();
}
       context.registerShutdownHook();
       
        
        
    }
}
