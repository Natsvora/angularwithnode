/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.hibernate.controller;

/**
 *
 * @author naimish
 */
import com.argusoft.hibernate.bean.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreData {

    public static void main(String[] args) {

        //creating configuration object  
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  

        //creating seession factory object  
        SessionFactory factory = cfg.buildSessionFactory();

        //creating session object  
        Session session = factory.openSession();

        //creating transaction object  
        Transaction t = session.beginTransaction();

        Student s = new Student();
        s.setId(1);
        s.setName("Naimish");

        session.save(s);//persisting the object  

        t.commit();//transaction is commited  
        session.close();

        System.out.println("successfully saved");

    }
}
