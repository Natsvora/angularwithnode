/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.dao;

import com.argusoft.jpa.User;
import java.util.List;

/**
 *
 * @author naimish
 */
public interface UserDAO {
    public List<User> list();
     
    public User get(int id);
     
    public void saveOrUpdate(User user);
     
    public void delete(int id);
}