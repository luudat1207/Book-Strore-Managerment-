<%-- 
    Document   : UpdateJobs
    Created on : Feb 17, 2022, 3:44:35 PM
    Author     : ptuan
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            String titlePage = (String) request.getAttribute("page");
            String titleTable =(String) request.getAttribute("table");
        %>
        <title><%=titlePage%></title>
    </head>
    <body>
        <%
            ResultSet rs = (ResultSet) request.getAttribute("rs");
        %>
        <%
            if(rs.next()){
        %>
        <form action="JobsController" method="post">
            <input type="hidden" name="go" value="updateJobs">
            <table>
                <tr>
                    <td>Job ID</td>
                    <td>
                        <input type="tex" name="job_id" value="<%=rs.getString(1)%>">
                    </td>
                </tr>
                <tr>
                    <td>Job Desc</td>
                    <td>
                        <input type="text" name ="job_desc" value="<%=rs.getString(2)%>">
                    </td>
                </tr>
                <tr>
                    <td>Min level</td>
                    <td>
                        <input type="number" name ="min_lvl" value="<%=rs.getString(3)%>">
                    </td>
                </tr>
                <tr>
                    <td>Max Level</td>
                    <td>
                        <input type="number" name ="max_lvl" value="<%=rs.getString(4)%>">
                    </td>
                </tr>
            </table>
            <p>
                <input type="submit" value="update" name="submit">
                <input type="reset" value="reset">
            </p>
        </form>
        <%}%>
    </body>
</html>
