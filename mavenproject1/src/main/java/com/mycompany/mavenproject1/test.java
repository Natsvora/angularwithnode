/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author naimish
 */
public class test {

    public static void main(String[] args) {
       LoginBean l = new LoginBean();
       l.setPass("aaa");
       l.setUserName("bbb");
       System.out.println(ContactDao.getContact(0));
    }
}
