<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Stark Go</title>

        <script src="bootstrap/scripts/jquery-1.7.1.min.js"></script>
        <script src="bootstrap/js/bootstrap.js"></script>
        <link href="bootstrap/css/shop-homepae.css" rel="stylesheet" />
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" />
        <link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet" />
        <link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet" />
        <link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" />
        <link
            href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.2.1/css/bootstrap-combined.min.css"
            rel="stylesheet">

        <link
            href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
            rel="stylesheet">
    </head>
    <body>
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
                            <a> <%="Welcome "+session.getAttribute("uname")
                            %></a>
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
        <div class="container">
            <ul class="breadcrumb">
                <li class="active"><c:url var="url" value="/category">
                        <c:param name="categ" value="${catName}" />
                    </c:url> <a href="${url}">${catName}</a> <span class="divider">/</span></li>
                <li class="active">${subCat}</li>
            </ul>
            <div class="row">
                <div class="span12">
                    <c:choose>
                        <c:when test="${not empty categoryProducts}">
                            <c:forEach var="products" items="${categoryProducts}">
                                <c:url var="url" value="/product">
                                    <c:param name="productId" value="${products.productId}" />
                                </c:url>
                                <div class="span3">
                                    <img src="images/meluha-small.jpg" /> </br> <a href="${url}">${products.productName}</a>
                                </div>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <c:forEach var="products" items="${productsCategoryList}">
                                <c:url var="url" value="/product">
                                    <c:param name="productId" value="${products.productId}" />
                                </c:url>
                                <div class="span3">
                                    <img src="images/small/meluha-small.jpg" /> </br> <a href="${url}">${products.productName}</a>
                                </div>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>


                </div>
            </div>
        </div>
    </body>


</html>