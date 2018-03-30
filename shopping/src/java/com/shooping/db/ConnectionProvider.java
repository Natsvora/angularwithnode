package com.shooping.db;
import static com.shooping.db.Provider.CONNECTION_URL;
import static com.shooping.db.Provider.DRIVER;
import static com.shooping.db.Provider.PASSWORD;
import static com.shooping.db.Provider.USERNAME;
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
