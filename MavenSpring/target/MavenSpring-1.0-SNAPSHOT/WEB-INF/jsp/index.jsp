<%-- 
    Document   : index
    Created on : 12 Feb, 2018, 3:07:32 PM
    Author     : naimish
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
    /* Navbar container */
    .navbar1 {
        overflow: hidden;
        background-color: #333;
        font-family: Arial;
    }

    /* Links inside the navbar */
    .navbar1 a {
        float: left;
        font-size: 16px;
        color: white;
        text-align: center;
        padding: 14px 16px;
        text-decoration: none;
    }

    /* The dropdown container */
    .dropdown1 {
        float: left;
        overflow: hidden;
    }

    /* Dropdown button */
    .dropdown1 .dropbtn1 {
        font-size: 16px; 
        border: none;
        outline: none;
        color: white;
        padding: 14px 16px;
        background-color: inherit;
        font-family: inherit; /* Important for vertical align on mobile phones */
        margin: 0; /* Important for vertical align on mobile phones */
    }

    /* Add a red background color to navbar links on hover */
    .navbar1 a:hover, .dropdown1:hover .dropbtn1 {
        background-color: red;
    }

    /* Dropdown content (hidden by default) */
    .dropdown1-content {
        display: none;
        position: absolute;
        background-color: #f9f9f9;
        min-width: 160px;
        box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
        z-index: 1;
    }

    /* Links inside the dropdown */
    .dropdown1-content a {
        float: none;
        color: black;
        padding: 12px 16px;
        text-decoration: none;
        display: block;
        text-align: left;
    }

    /* Add a grey background color to dropdown links on hover */
    .dropdown1-content a:hover {
        background-color: #ddd;
    }

    /* Show the dropdown menu on hover */
    .dropdown1:hover .dropdown1-content {
        display: block;
    }


</style>
 
<!--<a href="viewemp">View Employees</a>  -->
<div class="navbar1">

    <div class="dropdown1">
        <button class="dropbtn1">Employee 
            <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown1-content">
            <a href="empform">Add Employee</a>
            <a href="empeditform">Edit Employee</a>
            <a href="deleteempform">Delete Employee</a>
        </div>
    </div>
    <div class="dropdown1">
        <button class="dropbtn1">Department 
            <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown1-content">
            <a href="adddptform">Add Department</a>
            <a href="editdptform">Edit Department</a>
            <a href="deletedptform">Delete Department</a>
        </div>
    </div> 
    <div class="dropdown1">
        <button class="dropbtn1">Attendance 
            <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown1-content">
            <a href="addattendance">Add Attendance</a>
            <a href="modifyattendance">Modify Attendance</a>
        </div>
    </div> 
    <div class="dropdown1">
        <button class="dropbtn1">Report 
            <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown1-content">
            <a href="mntrpt">Monthly Report Of Attendance</a>
            <a href="serrpt">Search Employee</a>
        </div>
    </div> 
</div>