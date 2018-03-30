<%-- 
Document   : empform
Created on : 12 Feb, 2018, 3:16:31 PM
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
<style>
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
</style>
<table class="table table-bordered table">
    <thead>
        <tr>
            <th scope="col">
                <label class="my-1 mr-2" for="inlineFormCustomSelectPref">Select Department</label></th>
            <th scope="col"><select onclick="call()" class="custom-select my-1 mr-sm-2" id="getdeptid">
                    <option selected>Choose...</option>
                    <c:forEach var="dept" items="${deptlist}"> 
                        <option value=${dept.id}>${dept.name}</option>
                    </c:forEach>
                </select></th>

        </tr>
    </thead>
    <tbody>
        <tr>
            <th scope="col">
                <label class="my-1 mr-2" for="inlineFormCustomSelectPref">Select Employee</label></th>
            <th scope="col"><select  class="custom-select my-1 mr-sm-2" id="getempid">
                    <option selected  value="1">Choose...</option>
                    <c:forEach var="emp" items="${emplist}">
                        <option value=${emp.deptid} itemid=${emp.id}>${emp.name}</option>
                    </c:forEach>
                </select></th>

        </tr>
        <tr>
            <th scope="row">Select Date</th>
            <td>

                <div class="row">
                    <div class="col-md-7    ">
                        <input id="datepicker"  width="276" />
                    </div>
                    <div class="col-md-3">
                        <button class="btn" onclick="link()">Submit</button> 
                    </div>
                </div>	

                <script>
                    $('#datepicker').datepicker({
                        uiLibrary: 'bootstrap4',
                        format: "dd-mm-yyyy"
                    });

                </script>
            </td>


        </tr>
        <tr>
            <th scope="row">Select Date Range</th>
            <td>
                <div class="row">
                    <div class="col-lg-7">
                        Start Date: <input id="startDate" width="276" />
                        End Date: <input id="endDate" width="276" />
                    </div>
                    <div class="col-lg-3">
                        <button class="btn" onclick="myfun()">Submit</button> 
                    </div>
                </div>	

                <script>
                    var today = new Date(new Date().getFullYear(), new Date().getMonth(), new Date().getDate());
                    $('#startDate').datepicker({
                        uiLibrary: 'bootstrap4',
                        minDate: today,
                        maxDate: function () {
                            return $('#endDate').val();
                        }
                    });
                    $('#endDate').datepicker({
                        uiLibrary: 'bootstrap4',
                        minDate: function () {
                            return $('#startDate').val();
                        }
                    });
                </script>
            </td>

        </tr>


    </tbody>

</table>

<script>
    call = function () {
        var deptid = document.getElementById("getdeptid").value;
        var empdata = document.getElementById("getempid");
        var op = empdata.length;
        for (var i = 0; i < op; i++) {
            (empdata[i].value == deptid)
                    ? empdata[i].hidden = false
                    : empdata[i].hidden = true;
        }
    };
    link = function () {
        var a = document.getElementById("getempid");
        var d = a.options[a.selectedIndex].getAttribute('itemid');
        var b = document.getElementById("datepicker").value;

        var c = "addattendence/" + d + "/" + b;
        window.location.replace(c);
    };


</script>