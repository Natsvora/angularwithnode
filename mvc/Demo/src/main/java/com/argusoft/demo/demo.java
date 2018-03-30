/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.demo;

import com.argusoft.bussinesslogic.*;
import com.argusoft.data.*;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author naimish
 */
public class demo {
 
    public static void main(String[] args) throws IOException {
          
            
       
        LoginBean b = new LoginBean();
        b.setInputEmail("jay");
        b.setPassword("12341");
        System.out.println("data inserted sucessfully>>"+LoginDao.insert(b));
    }
}
