<%-- 
    Document   : DisplayEmployee
    Created on : Feb 10, 2022, 4:07:46 PM
    Author     : ptuan
--%>

<%@page import="model.DAOemployee,entity.employee"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%String titlepage = (String)request.getAttribute("titlepage");%>
        <title><%=titlepage%></title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <a href="index.html"> Home</a>
        <%
            Vector<employee> vector = (Vector<employee>)request.getAttribute("list");
            String titleTable = (String) request.getAttribute("titleTabale");
        %>
        
<table border="1">
            <caption><%=titleTable%></caption>
            <thead>
                <tr>
                    <th>emp_id</th>
                    <th>fname</th>
                    <th>minit</th>
                    <th>lname</th>
                    <th>job_id</th>
                    <th>jov_lvl</th>
                    <th>pub_id</th>
                    <th>hire_date</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (employee elem : vector) {
                %>
                <tr>
                    <td><%=elem.getEmp_id()%></td>
                    <td><%=elem.getFname()%></td>
                    <td><%=elem.getMinit()%></td>
                    <td><%=elem.getLname()%></td>
                    <td><%=elem.getJob_id()%></td>
                    <td><%=elem.getJob_lvl()%></td>
                    <td><%=elem.getPub_id()%></td>
                    <td><%=elem.getHire_date()%></td>
                    <td><a href="EmployeeController?go=updateEmployee&emp_id=<%=elem.getEmp_id()%>"> Update</td>
                    <td><a href="EmployeeController?go=deletEmployee&pub_id=<%=elem.getEmp_id()%>"> Delete</td>
                    <%}%>
                </tr>
            </tbody>
        </table>
    </body>
</html>
