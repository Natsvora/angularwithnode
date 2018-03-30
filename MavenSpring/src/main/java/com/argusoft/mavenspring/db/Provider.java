/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.mavenspring.db;

/**
 *
 * @author naimish
 */
public interface Provider {  
String DRIVER="com.mysql.jdbc.Driver";  
String CONNECTION_URL="jdbc:mysql://localhost:3306/employee?zeroDateTimeBehavior=convertToNull";  
String USERNAME="root";  
String PASSWORD="root";  
}  