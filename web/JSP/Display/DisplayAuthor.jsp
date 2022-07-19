<%-- 
    Document   : DisplayAuthor
    Created on : Feb 10, 2022, 4:06:46 PM
    Author     : ptuan
--%>

<%@page import="java.util.Vector"%>
<%@page import="model.DAOauthors,entity.authors,controller.AuthorsController"%>
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
        <div class="box">
            <a href="index.html" class="home"> Home</a>
        </div>
        <%
            Vector<authors> vector = (Vector<authors>)request.getAttribute("list");
            String titleTable = (String) request.getAttribute("titleTabale");
        %>
        <table border="1">
            <caption><%=titleTable%></caption>
            <thead>
                <tr>
                    <th>Authors ID</th>
                    <th>Au_Lname</th>
                    <th>Au_Fname</th>
                    <th>Phone</th>
                    <th>Address</th>
                    <th>City</th>
                    <th>State</th>
                    <th>Zip</th>
                    <th>Contract</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <%            for (authors elem : vector) {
                %>
                <tr>
                    <td><%=elem.getAu_id()%></td>
                    <td><%=elem.getAu_lname()%></td>
                    <td><%=elem.getAu_fname()%></td>
                    <td><%=elem.getPhone()%></td>
                    <td><%=elem.getAddress()%></td>
                    <td><%=elem.getCity()%></td>
                    <td><%=elem.getState()%></td>
                    <td><%=elem.getZip()%></td>
                    <td><%=elem.getContract()%></td>
                    <td><a href="AuthorsController?go=updateAuthor&au_id=<%=elem.getAu_id()%>"> Update</td>
                    <td><a href="AuthorsController?go=deleteAuthor&au_id=<%=elem.getAu_id()%>"> Delete</td>
                    <%}%>
                </tr>
            </tbody>
        </table>
    </body>
</html>
