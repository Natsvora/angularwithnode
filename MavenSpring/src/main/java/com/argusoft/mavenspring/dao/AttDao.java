/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.mavenspring.dao;

import com.argusoft.mavenspring.bean.Att;
import com.argusoft.mavenspring.bean.Dept;
import com.argusoft.mavenspring.bean.Emp;
import com.argusoft.mavenspring.bean.Report;
import com.argusoft.mavenspring.db.ConnectionProvider;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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
public class AttDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    
    private String newDateString;

    public Boolean insertAtt(final int id, String date) throws ParseException {
        String query = "insert into attendance (empid,date) VALUES(?,?)";

        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        final Date startDate = df.parse(date);
        newDateString = df.format(startDate);

        return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {
                System.out.println("hello"+id);
                ps.setInt(1, id);
                ps.setDate(2, new java.sql.Date(startDate.getTime()));
                return ps.execute();

            }
        });

    }

    public List getAll() {
        String query = "select * from  attendance join emp on emp.idemp = attendance.empid order by empid";

        return jdbcTemplate.query(query, new RowMapper<Att>() {
            public Att mapRow(ResultSet rs, int row) throws SQLException {
                Att e = new Att();
                e.setId(rs.getInt("id"));
                e.setName(rs.getString("name"));
                e.setDate(rs.getDate("date"));
                return e;
            }
        });
    }

    public Boolean delete(final int id) {
        String query = "delete from attendance where empid=?";

        return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                ps.setInt(1, id);
                return ps.execute();

            }
        });
    }

    public List getReport() {
        String query = "SELECT count(*) as present,name,idemp FROM attendance join emp on emp.idemp=attendance.empid WHERE MONTH(date) = MONTH(CURRENT_DATE())AND YEAR(date) = YEAR(CURRENT_DATE()) group by idemp";

        return jdbcTemplate.query(query, new RowMapper<Report>() {
            public Report mapRow(ResultSet rs, int row) throws SQLException {
                Report r = new Report();
                r.setId(rs.getInt("idemp"));
                r.setName(rs.getString("name"));

                int pres = rs.getInt("present");
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                String strDate = formatter.format(date);
                String[] ymd = strDate.split("/");
                int year = Integer.parseInt(ymd[0]);
                int month = Integer.parseInt(ymd[1]);
                int day = Integer.parseInt(ymd[2]);
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                int daysQty = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

                r.setPre(pres);
                r.setAbs(daysQty - pres);
                return r;
            }
        });

    }

    public List serchReport(String str) {
        String query = "SELECT * FROM emp  where name LIKE '%" + str + "%'";

        return jdbcTemplate.query(query, new RowMapper<Emp>() {
            public Emp mapRow(ResultSet rs, int row) throws SQLException {

                Emp a = new Emp();
                a.setId(rs.getInt("idemp"));
                a.setName(rs.getString("name"));
                a.setDesignation(rs.getString("desi"));
                a.setSalary(rs.getInt("salary"));
                a.setDeptid(rs.getInt("deptid"));
                return a;
            }
        });

    }
}
