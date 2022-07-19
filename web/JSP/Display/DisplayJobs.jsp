<%-- 
    Document   : DisplayJobs
    Created on : Feb 10, 2022, 4:08:00 PM
    Author     : ptuan
--%>

<%@page import="java.util.Vector"%>
<%@page import="model.DAOjobs,entity.jobs"%>
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
            Vector<jobs> vector = (Vector<jobs>)request.getAttribute("list");
            String titleTable = (String) request.getAttribute("titleTabale");

        %>
        <table border="1">
            <caption><%=titleTable%></caption>
            <thead>
                <tr>
                    <th>job_id</th>
                    <th>job_desc</th>
                    <th>min_lvl</th>
                    <th>max_lvl</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <%                    for (jobs elem : vector) {
                %>
                <tr>
                    <td><%=elem.getJob_id()%></td>
                    <td><%=elem.getJob_desc()%></td>
                    <td><%=elem.getMin_lv()%></td>
                    <td><%=elem.getMax_lv()%></td>
                    <td><a href="JobsController?go=updateJobs&jobsID=<%=elem.getJob_id()%>"> Update</td>
                    <td><a href="JobsController?go=deleteJobs&jobsID=<%=elem.getJob_id()%>"> Delete</td>
                    <%}%>
                </tr>
            </tbody>
        </table>
    </body>
</html>
