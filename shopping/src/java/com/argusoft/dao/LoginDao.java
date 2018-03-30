package com.argusoft.dao;

import com.argusoft.bean.LoginBean;
import com.shooping.db.ConnectionProvider;
import java.sql.*;

public class LoginDao {

    public static boolean validate(LoginBean bean) {
        boolean status = false;
        try {
            Connection con = ConnectionProvider.getCon();

            PreparedStatement ps = con.prepareStatement("select * from user where inputEmail=? and password=?");
            ps.setString(1, bean.getInputEmail());
            ps.setString(2, bean.getPassword());

            ResultSet rs = ps.executeQuery();
            status = rs.next();
           
        } catch (Exception e) {
        }
        return status;
    }

    public static int insert(LoginBean bean) {
        int status = 0;
        try {
            Connection con = ConnectionProvider.getCon();

            PreparedStatement ps = con.prepareStatement("insert into user (inputEmail,password) VALUES(?,?)");
            ps.setString(1, bean.getInputEmail());
            ps.setString(2, bean.getPassword());

            status = ps.executeUpdate();
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;

    }

    public static int getId(String uname) {
        int id = 0;
        try {
            Connection con = ConnectionProvider.getCon();

            PreparedStatement ps = con.prepareStatement("select * from user where inputEmail =?");
            ps.setString(1, uname);
            ResultSet rs = ps.executeQuery();
            rs.next();
            id = rs.getInt("id");
            System.out.println(id);

        } catch (Exception e) {
            System.out.println(e);
        }
        return id;
    }
}
