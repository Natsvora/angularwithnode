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
import com.argusoft.hibernatexml.model.User;
import java.util.List;



public interface UserDAO {
	public List<User> list();

    public void saveOrUpdate(User user);

    public void add();
}