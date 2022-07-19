<%-- 
    Document   : DisplayRoy
    Created on : Feb 10, 2022, 4:08:36 PM
    Author     : ptuan
--%>

<%@page import="java.util.Vector"%>
<%@page import="model.DAOroysched,entity.roysched"%>
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
            Vector<roysched> vector = (Vector<roysched>)request.getAttribute("list");
            String titleTable = (String) request.getAttribute("titleTabale");

        %>
        <table border="1">
            <caption>List Roy</caption>
            <thead>
                <tr>
                    <th>title_id</th>
                    <th>Lorange</th>
                    <th>hirange</th>
                    <th>royalty</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <%                    for (roysched elem : vector) {
                %>
                <tr>
                    <td><%=elem.getTitle_id()%></td>
                    <td><%=elem.getLorange()%></td>
                    <td><%=elem.getHirange()%></td>
                    <td><%=elem.getRoyalty()%></td>
                    <td><a href="RoyschedController?go=updateRoysched&title_id=<%=elem.getTitle_id()%>"> update</td>
                    <td><a href="RoyschedController?go=deleteRoy&title_id=<%=elem.getTitle_id()%>"> delete</td>
                    <%}%>
                </tr>
            </tbody>
        </table>
    </body>
</html>
