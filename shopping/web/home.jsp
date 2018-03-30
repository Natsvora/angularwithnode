<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>ShoppingKart</title>
        <link href="bootstrap/css/shop-homepae.css" rel="stylesheet" />
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" />
        <link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet" />
        <link
            href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.2.1/css/bootstrap-combined.min.css"
            rel="stylesheet">
        <script src="bootstrap/scripts/jquery-1.7.1.min.js"></script>
        <script src="bootstrap/js/bootstrap.js"></script>
        <style>
            body {
                background-color: white;
            }

            #cartitem {
                display: inline;
            }

            #welcome {
                display: inline;
                height: 20px;
            }
        </style>
    </head>
    <body>
        <!--Header-->
    <header>
        <nav class="navbar navbar-inverse" role="navigation">
            <div class="navbar-inner">
                <a class="brand" href="home.jsp">Stark Go</a> <a
                    class="btn btn-navbar" data-toggle="collapse"
                    data-target=".nav-collapse"> <span class="icon-bar"></span> <span
                        class="icon-bar"></span> <span class="icon-bar"></span>
                </a>

                <div class="nav-collapse collapse">

                    <ul class="nav pull-right">
                        <li>
                                <a> <%="Welcome " + session.getAttribute("uname")%></a>
                        </li>
                        <li>
                            <a 
                                href="index.jsp">Sign out
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav> 
    </header>

    <div class="container">

        <div class="container">
            <div class="row">
                <div class="span12">
                    <c:forEach var="products" items="${productsList}">
                        <c:url var="url" value="/product">
                            <c:param name="productId" value="${products.productId}" />
                        </c:url>
                        <div class="span3">
                            <img class="img-circle"src="../src/java/com/argusoft/images/small/101.jpg"/></br> <a>${products.productId}</a><a>${products.productName}</a>
                        </div>
                    </c:forEach>

                </div>
            </div>
        </div>
    </div>
</body>
</html>