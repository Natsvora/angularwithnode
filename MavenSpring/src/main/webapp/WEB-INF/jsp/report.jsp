<%-- 
    Document   : report
    Created on : 14 Feb, 2018, 2:13:48 PM
    Author     : naimish
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<%@include file="index.jsp" %>
<hr>
<style>
    table {
        border-collapse: collapse;
        border-spacing: 0;
        width: 100%;
        border: 1px solid #ddd;
        text-align: center;
    }

    th, td {
        text-align: left;
        padding: 16px;
        text-align: center;
    }

    tr:nth-child(even) {
        background-color: #f2f2f2
    }
    button {
        background-color: #4CAF50;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        cursor: pointer;
        width: 100%;
    }

    button:hover {
        opacity: 0.8;
    }
</style>
<table border="2" width="70%" cellpadding="2">  
    <tr><th>Id</th><th>Employee Name</th><th>Present</th><th>Not Present</th></tr>  
            <c:forEach var="report" items="${list}">   
        <tr>  
            <td>${report.id}</td>
            <td>${report.name}</td>
            <td>${report.pre}</td>
            <td>${report.abs}</td>
        </tr>  
    </c:forEach>  
</table>