/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.dao;

import com.argusoft.bean.Product;
import com.shooping.db.ConnectionProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author naimish
 */
public class ProductDao {

    private static List<Product> products = null;

    public static List<Product> getAllProducts() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql;
        conn = ConnectionProvider.getCon();
        sql = "select * from products";
        products = new ArrayList<Product>();

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Product p = new Product(rs.getInt("productID"),
                        rs.getString("productName"),
                        rs.getDouble("productPrice"));
                products.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }

        }

        return products;

    }

}
