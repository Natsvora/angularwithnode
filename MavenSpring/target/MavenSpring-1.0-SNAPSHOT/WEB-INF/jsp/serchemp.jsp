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

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/gh/atatanasov/gijgo@1.8.0/dist/combined/js/gijgo.min.js" type="text/javascript"></script>
<link href="https://cdn.jsdelivr.net/gh/atatanasov/gijgo@1.8.0/dist/combined/css/gijgo.min.css" rel="stylesheet" type="text/css" />
<form action="serrpt" method="post">
    <table class="table table-bordered table-dark">
        <thead>
            <tr>
                <th scope="col">
                    <label class="my-1 mr-2" >Enter Employee Name</label></th>
                <th scope="col">
                    <input name="ename" type="text" class="form-control" aria-label="Employee Name"/>
                </th>

            </tr>
        </thead>
        <tbody>


        </tbody>
    </table>
    <button type="submit" class="btn btn-primary"  style="margin: auto;margin-bottom: 1rem; display: block;" data-toggle="modal" data-target="#exampleModalCenter">
        Get Employee Details
    </button>
</form>
<table class="table table-striped  table-hover">
    <thead>
        <tr>
            <th scope="col">
                <label class="my-1 mr-2" for="inlineFormCustomSelectPref">id</label></th>
            <th scope="col">
                <label class="my-1 mr-2" for="inlineFormCustomSelectPref">Name</label></th>
            <th scope="col">
                <label class="my-1 mr-2" for="inlineFormCustomSelectPref">DepartMent Id</label></th>
            <th scope="col">
                <label class="my-1 mr-2" for="inlineFormCustomSelectPref">Salary</label></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="emp" items="${list}">
            <tr>
                <td>${emp.id}</td>
                <td>${emp.name}</td>
                <td>${emp.deptid}</td>
                <td>${emp.salary}</td>
            </tr>
        </c:forEach>


    </tbody>
</table>

