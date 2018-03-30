package com.argusoft.connection;

import static com.argusoft.connection.Provider.CONNECTION_URL;
import static com.argusoft.connection.Provider.DRIVER;
import static com.argusoft.connection.Provider.PASSWORD;
import static com.argusoft.connection.Provider.USERNAME;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class ConnectionProvider {

    static Connection con = null;
    static InputStream  is=null;

    static {
        try {
            is = this.getClass().getResourceAsStream("my.properties");
            java.util.Properties p = new Properties();
            p.load(is);
            String name = p.getProperty("pass");
            System.out.println(name);
            Class.forName(DRIVER);
            con = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static Connection getCon() {
        return con;
    }

   
}
