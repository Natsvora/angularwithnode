<%-- 
    Document   : login
    Created on : 2 Feb, 2018, 11:48:15 AM
    Author     : naimish
--%>
<style>
    .container{
    	margin-top: 2rem;
    	display: flex;
    	padding: 3rem;
    	flex-direction: column;
    	align-items: center;
    	box-shadow: inset 0px 0px 15px 5px rgba(0,0,0,0.5);
    	background-color: #ccc;
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
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navbar.jsp" %>

<form method="post" name="login" action="home.jsp">
            <div class="container">
                <div class="dis-block">
	                <label><b>Username</b></label>
	                <input type="text" placeholder="Enter Username" name="userName" >	
                </div>
                <div class="dis-block">
                	<label><b>Password</b></label>
                	<input type="password" placeholder="Enter Password" name="pass">
                </div>
                <button  type="submit">Login</button>
            </div>
        </form>