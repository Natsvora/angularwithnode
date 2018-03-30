<%-- 
    Document   : navbar.jsp
    Created on : 2 Feb, 2018, 12:35:42 PM
    Author     : naimish
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<style>
    .flex-container{
        display: flex;
        flex:1;
        justify-content: space-around;
        flex-wrap: wrap;
    }
    a{
        text-decoration: none;
        font-size: 2rem;
    }
    a:hover{
        background: rgba(0,0,0, 0.2);
    }
</style>
<div class="flex-container">
    <a href="operation.jsp" name="add" id="add"> Add Contact</a>
    <a href="show.jsp" name="show" id="show"> Show Contacts</a>
    <a href="register.jsp" name="show" id="show">Register</a>
    <a href="index.jsp" name="show" id="show">Login</a>
</div>
<hr/>
