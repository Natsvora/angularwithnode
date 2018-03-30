/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.mavenspring.dao;

import com.argusoft.mavenspring.bean.Dept;
import com.argusoft.mavenspring.bean.Emp;
import com.argusoft.mavenspring.db.ConnectionProvider;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;

public class EmpDao {
@Autowired
    private JdbcTemplate jdbcTemplate;
  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Boolean insert(final Emp bean) {
        int status = 0;
        String query = "insert into emp (name,desi,salary,deptid) VALUES(?,?,?,?)";
        return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                ps.setString(1, bean.getName());
                ps.setString(2, bean.getDesignation());
                ps.setString(3, "" + bean.getSalary());
                System.out.println(bean.getDeptid());
                ps.setInt(4, bean.getDeptid());
                return ps.execute();

            }
        });
    }

    public Boolean delete(final int id) {
        String query = "delete from emp where idemp=?";
        return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                ps.setInt(1, id);
                return ps.execute();

            }
        });
    }

    public Boolean update(final Emp bean) {
        String query = "update  emp set name=?,desi=?,salary=? where idemp = ?";

        return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                ps.setString(1, bean.getName());
                ps.setString(2, bean.getDesignation());
                ps.setString(3, "" + bean.getSalary());
                ps.setInt(4, bean.getId());
                return ps.execute();

            }
        });
    }

    public List<Emp> getAll() {
        return jdbcTemplate.query("select * from emp ", new RowMapper<Emp>() {
            public Emp mapRow(ResultSet rs, int row) throws SQLException {
                Emp e = new Emp(rs.getInt("idemp"), rs.getString("Name"), Float.parseFloat(rs.getString("salary")), rs.getString("desi"));
                e.setDeptid(rs.getInt("deptid"));
                return e;
            }
        });
    }

//    public int getid(Emp bean) {
//        int status = -1;
//        try {
//            Connection con = ConnectionProvider.getCon();
//
//            PreparedStatement ps = con.prepareStatement("select * from emp where name=?");
//            ps.setString(1, bean.getName());
//
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                return rs.getInt("idemp");
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
