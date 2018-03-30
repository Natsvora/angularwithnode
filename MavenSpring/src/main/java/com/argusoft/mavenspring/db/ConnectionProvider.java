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
import static com.argusoft.mavenspring.db.Provider.CONNECTION_URL;
import static com.argusoft.mavenspring.db.Provider.DRIVER;
import static com.argusoft.mavenspring.db.Provider.PASSWORD;
import static com.argusoft.mavenspring.db.Provider.USERNAME;

import java.sql.*;

public class ConnectionProvider {
	static Connection con=null;
	static{
		try{
			Class.forName(DRIVER);
			con=DriverManager.getConnection(CONNECTION_URL,USERNAME,PASSWORD);
			}catch(Exception e){
                        System.out.println(e);}
	}
	public static Connection getCon(){
		return con;
	}
}