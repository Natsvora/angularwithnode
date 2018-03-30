package com.mycompany.mavenproject1;

import java.sql.*;

public class ContactDao {

    public static int register(int id, ContactBean u) {
        int status = 0;
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("insert into contact values(?,?,?)");
            ps.setInt(1, id);
            ps.setString(2, u.getUname());
            ps.setString(3, u.getContact());

            status = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

        return status;
    }

    public static String getContact(int id) {

        try {

            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement(
                    "select * from contact where id=?");

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            String str="";
            while(rs.next())
            {
                str += "<tr><td>"+rs.getString("name")+"</td><td>"+rs.getString("contact")+"</td></tr>";
            }
            return str;

        } catch (Exception e) {
            System.out.println(e);
        }
        return "";
    }

}
