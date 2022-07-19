<%-- 
    Document   : DisplayPublisher
    Created on : Feb 10, 2022, 4:08:24 PM
    Author     : ptuan
--%>

<%@page import="java.util.Vector"%>
<%@page import="model.DAOpublishers,entity.publishers"%>
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
            Vector<publishers> vector = (Vector<publishers>)request.getAttribute("list");
            String titleTable = (String) request.getAttribute("titleTabale");
        %>
        <table border="1">
            <caption>List Publisher</caption>
            <thead>
                <tr>  
                    <th>pub_ID</th>
                    <th>pub_name</th>
                    <th>city</th>
                    <th>state</th>
                    <th>country</th>
                    <th>Image</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (publishers elem : vector) {
                %>
                <tr>
                    <td><%=elem.getPub_id()%></td>
                    <td><%=elem.getPub_name()%></td>
                    <td><%=elem.getCity()%></td>
                    <td><%=elem.getState()%></td>
                    <td><%=elem.getCountry()%></td>
                    <td><img src="<%=elem.getImage()%>"></td>
                    <td><a href="PublishersController?go=updatePublisher&pub_id=<%=elem.getPub_id()%>"> Update</td>
                    <td><a href="PublishersController?go=deletepub&pub_id=<%=elem.getPub_id()%>"> Delete</td>
                    <%}%>
                </tr>
            </tbody>
        </table>
    </body>
</html>
