
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    


<form:form method="post" action="save" commandName="state">    
    <table >    
        <tr>    
            <td>Enter State Name : </td>   
            <td><form:input path="state"  /></td>  
        </tr>    
       
        <tr> 
            <td colspan="2"><input type="submit" value="Find Abbrivation" /></td>    
        </tr>    
    </table>    
</form:form>    
