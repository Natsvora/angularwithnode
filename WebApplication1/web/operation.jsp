<%-- 
    Document   : operaion.jsp
    Created on : 2 Feb, 2018, 12:44:04 PM
    Author     : naimish
--%>
<%@page import="bean.LoginDao"%>
<%@page import="bean.ContactDao"%>  
<jsp:useBean id="obj" class="bean.ContactBean"/>  
<jsp:setProperty property="*" name="obj"/> 

<%@include file="navbar.jsp" %>
<%! boolean visited = false;%>
<%
    String str = obj.getContact();
    if (!visited) {
        out.print("Welcome to contact Book :- " + session.getAttribute("user"));
        visited = true;

    } else if (str != null && visited) {
        int id = LoginDao.getId("" + session.getAttribute("user"));
        int status = ContactDao.register(id, obj);
        if (status > 0) {
            out.println("your contact added sucessfully");
        } else {
            out.println("plz try again letter");
        }

    } else {
        out.print("plz enter contact");
    }
%>
<style>
    .container{
    	margin-top: 2rem;
    	display: flex;
    	padding: 3rem;
    	flex-direction: column;
    	align-items: center;
    	box-shadow: inset 0px 0px 15px 5px rgba(0,0,0,0.5);
    	background-color: #ccc;
    	flex-wrap:  wrap;
    }
    button{
		display: block;
		margin: auto;
		padding: 0.5rem;
    }
    .dis-block{
		display: block;
		padding: 1rem;
    }
</style>
<form action="operation.jsp">
    <div class="container">
        <div class="dis-block">
            <label><b>Username</b></label>
            <input type="text"  name="uname"  >
        </div>
        <div class="dis-block">
            <label><b>Enter Contact</b></label>
            <input type="text" name="contact">
        </div>
        <input type="submit"value="AddContact">
    </div>
</form>