/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.mavenspring.dao;

import com.argusoft.mavenspring.bean.Dept;
import com.argusoft.mavenspring.bean.Emp;
import com.argusoft.mavenspring.db.ConnectionProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author naimish
 */
public class DeptDao {
@Autowired
    private JdbcTemplate jdbcTemplate;

  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Boolean insert(final Dept bean) {
        String query = "insert into dept (name,location) VALUES(?,?)";

        return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                ps.setString(1, bean.getName());
                ps.setString(2, bean.getLocation());

                return ps.execute();

            }
        });

    }

    public Boolean delete(final int id) {
        String query = "delete from dept where id=?";

        return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                ps.setInt(1, id);
                return ps.execute();

            }
        });

    }

    public Boolean update(final Dept bean) {
        String query = "update  dept set name=?,location=? where id = ?";

        return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                ps.setString(1, bean.getName());
                ps.setString(2, bean.getLocation());
                ps.setInt(3, bean.getId());
                return ps.execute();

            }
        });
    }

    public List<Dept> getAll() {
        return jdbcTemplate.query("select * from dept ", new RowMapper<Dept>() {
            public Dept mapRow(ResultSet rs, int row) throws SQLException {
                Dept e = new Dept(rs.getInt("id"), rs.getString("name"), rs.getString("location"));
                return e;
            }
        });
    }

//    public static int getid(Dept bean) {
//        int status = -1;
//        try {
//            Connection con = ConnectionProvider.getCon();
//
//            PreparedStatement ps = con.prepareStatement("select * from dept where name=?");
//            ps.setString(1, bean.getName());
//
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                return rs.getInt("id");
//            }
//
//            System.out.println("sucessfully insert");
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return status;
//
//    }
}
