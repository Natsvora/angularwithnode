<%-- 
    Document   : viewemp
    Created on : 12 Feb, 2018, 3:16:52 PM
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
    }

    th, td {
        text-align: left;
        padding: 16px;
    }

    tr:nth-child(even) {
        background-color: #f2f2f2
    }
</style>
<table border="2" width="70%" cellpadding="2">  
    <tr><th>Id</th><th>Name</th><th>Location</th></tr>  
            <c:forEach var="dept" items="${list}">   
        <tr>  
            <td>${dept.id}</td>  
            <td>${dept.name}</td>  
            <td>${dept.location}</td>  
        </tr>  
    </c:forEach>  
</table>  