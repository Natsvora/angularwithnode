/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author naimish
 */
import org.springframework.beans.factory.BeanFactory;  
import org.springframework.beans.factory.xml.XmlBeanFactory;  
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;  
import org.springframework.core.io.Resource;  

public class Test {

    public static void main(String[] args) {
//        Resource resource = new ClassPathResource("Config.xml");
//        BeanFactory factory = new XmlBeanFactory(resource);
//
//        Student student = (Student) factory.getBean("Student");
        
        ApplicationContext context = new ClassPathXmlApplicationContext("Config.xml");
        Student student = (Student)context.getBean("Student");
        student.displayInfo();
    }
}
