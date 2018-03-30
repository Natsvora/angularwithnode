/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.springtest;

import com.sun.org.apache.xml.internal.utils.LocaleUtility;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author naimish
 */
public class Test {

    private static Scanner sc = null;
    private static int lan =1;

    private static void showStudent(ApplicationContext context) {
        School obj = (School) context.getBean("school");
        for (Student st : obj.getStudent()) {
            System.out.println(st.getName() + " " + st.getAge());
        }
    }

    private static void showSchool(ApplicationContext context) {
        School obj = (School) context.getBean("school");
        System.out.println(obj.getId() + " " + obj.getName());
    }

    Test() {

    }

    public static void insertStudent(ApplicationContext context) {
        School obj = (School) context.getBean("school");
        System.out.println(context.getMessage(lan+".std", null, "Not Found", null));
        int stuno = sc.nextInt();
        sc.nextLine();

        while (stuno > 0) {
            Student s = (Student) context.getBean("student");
            System.out.println(context.getMessage(lan+".name", null, "Not Found", null));

            s.setName(sc.nextLine());
            System.out.println(context.getMessage(lan+".age", null, "Not Found", null));

            s.setAge(sc.nextInt());
            obj.addStudent(s,context,lan);
            stuno -= 1;
            sc.nextLine();
        }

    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        System.out.println("enter 1 for English and 2 for Gujrati"); 
        lan = sc.nextInt();
        sc.nextLine();
        l1:
        while (true) {
            System.out.println(context.getMessage(lan+".mess", null, "Not Found", null));
            int a = sc.nextInt();
            sc.nextLine();
            switch (a) {
                case 1:
                    insertStudent(context);
                    break;
                case 2:
                    showStudent(context);
                    break;
                case 3:
                    showSchool(context);
                    break;
                case 4:System.out.println("");
                       lan = sc.nextInt();
                       sc.nextLine();
                        break;
                case 999:
                    break l1;
            }
        }
        System.out.println(context.getMessage(lan+".bye", null, "Not Found", null));
    }
}
