<%-- 
    Document   : show.jsp
    Created on : 2 Feb, 2018, 4:47:08 PM
    Author     : naimish
--%>

<%@page import="bean.LoginDao"%>
<%@page import="bean.ContactDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <style>
            h1{
                text-align: center;
                border-bottom: 5px solid black;
            }
            table{
                margin: auto;
            }
            th, td {
                padding: 0.5rem 2rem;
                border-style: double;
                text-align: left;    
            }
        </style>
    </head>
    <body>
        <h1>Your Contact</h1>
        <table>
            <tr>
            <td>
                Name
            </td>
            <td>
                ContactNo.
            </td>
            </tr>
            <%=
               ContactDao.getContact(LoginDao.getId(""+session.getAttribute("uname")))
            %>
        </table>
    </body>
</html>
