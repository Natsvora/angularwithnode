<%-- 
    Document   : empform
    Created on : 12 Feb, 2018, 3:16:31 PM
    Author     : naimish
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@include file="index.jsp" %>
<style>
    body {font-family: Arial, Helvetica, sans-serif;}

    /* Full-width input fields */
    input[type=text], input[type=password] {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        box-sizing: border-box;
    }

    /* Set a style for all buttons */
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

    /* Extra styles for the cancel button */
    .cancelbtn {
        width: auto;
        padding: 10px 18px;
        background-color: #f44336;
    }

    /* Center the image and position the close button */
    .imgcontainer {
        text-align: center;
        margin: 24px 0 12px 0;
        position: relative;
    }

    img.avatar {
        width: 40%;
        border-radius: 50%;
    }

    .container {
        padding: 16px;
    }

    span.psw {
        float: right;
        padding-top: 16px;
    }

    /* The Modal (background) */
    .modal {
        display: none; /* Hidden by default */
        position: fixed; /* Stay in place */
        z-index: 1; /* Sit on top */
        left: 0;
        top: 0;
        width: 100%; /* Full width */
        height: 100%; /* Full height */
        overflow: auto; /* Enable scroll if needed */
        background-color: rgb(0,0,0); /* Fallback color */
        background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
        padding-top: 60px;
    }

    /* Modal Content/Box */
    .modal-content {
        background-color: #fefefe;
        margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
        border: 1px solid #888;
        width: 80%; /* Could be more or less, depending on screen size */
    }

    /* The Close Button (x) */
    .close {
        position: absolute;
        right: 25px;
        top: 0;
        color: #000;
        font-size: 35px;
        font-weight: bold;
    }

    .close:hover,
    .close:focus {
        color: red;
        cursor: pointer;
    }

    /* Add Zoom Animation */
    .animate {
        -webkit-animation: animatezoom 0.6s;
        animation: animatezoom 0.6s
    }

    @-webkit-keyframes animatezoom {
        from {-webkit-transform: scale(0)} 
        to {-webkit-transform: scale(1)}
    }

    @keyframes animatezoom {
        from {transform: scale(0)} 
        to {transform: scale(1)}
    }

    /* Change styles for span and cancel button on extra small screens */
    @media screen and (max-width: 300px) {
        span.psw {
            display: block;
            float: none;
        }
        .cancelbtn {
            width: 100%;
        }
    }
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
<hr>



<table border="2" width="70%" cellpadding="2">  
    <tr><th>Id</th><th>Name</th><th>Location</th><th>Edit</th></tr>  
            <c:forEach var="emp" items="${list}">   
        <tr id=${emp.id}>  
            <td >${emp.id}</td>  
            <td>${emp.name}</td>  
            <td>${emp.salary}</td>  
            <td>${emp.designation}</td>

            <td><button onclick="model(document.getElementById(${emp.id}))">${emp.id}</button></td>
        </tr>  
    </c:forEach>  
</table>

<div id="id01" class="modal">

    <form class="modal-content animate" method="post" action="/MavenSpring/updateempform">
        <div class="imgcontainer">
            <span onclick="document.getElementById('id01').style.display = 'none'" class="close" title="Close Modal">&times;</span>
        </div>

        <div class="container">
             <label for="uname"><b>id</b></label>
             <input type="text" id="f0" placeholder="Enter Username" name="id" disabled="true" />
            
            <label for="uname"><b>Employee Name</b></label>
            <input type="text" id="f1" placeholder="Enter Username" name="name" />

            <script>
                function getId() {
                    alert(${emp.id});
                }
            </script>
            <label for="psw"><b>Salary</b></label>
            <input type="text" id="f2" placeholder="Enter Salary" name="salary" />

            <label for="psw"><b>Designation</b></label>
            <input type="text"  id="f3" placeholder="Enter Designation"  name="designation" />

            <button type="submit">Edit</button>

        </div>
    </form>
    <!--   document.getElementById('id01').style.display = 'block'" -->
</div>

<script>
// Get the modal
    var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
    window.onclick = function (event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }

    }



    model = function (desi) {
        //alert(id);
       // console.log(L);

        document.getElementById('id01').style.display = 'block';
        document.getElementById('f0').value = desi.children[0].innerHTML;
        document.getElementById('f1').value = desi.children[1].innerHTML;
        document.getElementById('f2').value = desi.children[2].innerHTML;
        document.getElementById('f3').value = desi.children[3].innerHTML;
    }
</script>