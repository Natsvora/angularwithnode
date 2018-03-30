<%-- 
    Document   : addcontact.jsp
    Created on : 2 Feb, 2018, 11:54:45 AM
    Author     : naimish
--%>
<%@page import="bean.LoginDao"%>  
<jsp:useBean id="obj" class="bean.LoginBean"/>  
<jsp:setProperty property="*" name="obj"/>  

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navbar.jsp" %>
<%
    boolean status = LoginDao.validate(obj);
    if (status) {
        out.println("Welcome Back happy to see u agin");
    }
    else
    {
        int stat = LoginDao.insert(obj);
        if(stat>0)
        {
            out.println("You r successfully logged in");
        }
        else
        {
            out.println("Somthing goes wrong");
        }
    }
%>
<%
    String name = request.getParameter("userName");
    session.setAttribute("user", name);
    
%>