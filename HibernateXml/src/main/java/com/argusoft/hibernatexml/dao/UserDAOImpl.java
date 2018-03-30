/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.hibernatexml.dao;

/**
 *
 * @author naimish
 */
import com.argusoft.hibernatexml.model.Student;
import com.argusoft.hibernatexml.model.StudentDetails;
import com.argusoft.hibernatexml.model.User;
import java.util.List;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;

public class UserDAOImpl implements UserDAO {

    private SessionFactory sessionFactory;

    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<User> list() {
        @SuppressWarnings("unchecked")
        List<User> listUser = (List<User>) sessionFactory.getCurrentSession()
                .createCriteria(User.class)
                .list();

        return listUser;
    }

    @Override
    @Transactional
    @org.springframework.transaction.annotation.Transactional
    public void saveOrUpdate(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    @Transactional
    @org.springframework.transaction.annotation.Transactional
    public void add() {

        Student s = new Student();
        s.setName("Naimish");

        StudentDetails sd = new StudentDetails();
        sd.setMobileno("12345678");
        sd.setStudent(s);
        
        StudentDetails sd1 = new StudentDetails();
        sd1.setMobileno("98756542");
        sd1.setStudent(s);
        
        sessionFactory.getCurrentSession().save(sd);
        
        sessionFactory.getCurrentSession().save(sd1);
    }
}
