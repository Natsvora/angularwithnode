<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<jsp:useBean id="obj" class="com.argusoft.bean.LoginBean"/>  
<jsp:setProperty property="*" name="obj"/> 
<%@page import="com.argusoft.dao.LoginDao"%>  
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Stark Go</title>
        <link href="bootstrap/css/shop-homepae.css" rel="stylesheet" />
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" />
        <link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet" />
        <link
            href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.2.1/css/bootstrap-combined.min.css"
            rel="stylesheet">
        <link
            href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
            rel="stylesheet">
        <script src="bootstrap/scripts/jquery-1.7.1.min.js"></script>
        <script src="bootstrap/js/bootstrap.js"></script>
        <style>
            .paymentinfo ul {
                margin: 0;
                padding: 0;
                list-style-type: none;
            }

            .paymentinfo ul li {
                display: inline;
            }
        </style>
    </head>
    <body>
        <!--Header-->
        <header> <nav class="navbar navbar-inverse" role="navigation">
                <div class="navbar-inner">
                    <a class="brand" href="home.jsp">Stark Go</a> <a
                        class="btn btn-navbar" data-toggle="collapse"
                        data-target=".nav-collapse"> <span class="icon-bar"></span> <span
                            class="icon-bar"></span> <span class="icon-bar"></span>
                    </a>
                </div>
            </nav> </header>

        <!-- Section -->

    </body>
    <%
         int status = LoginDao.insert(obj);
    if (status>0) {
       out.println("Signup Sucessfully");
    }
    else
        out.println("Somthing goes Wrong try again");
    %>
</html>