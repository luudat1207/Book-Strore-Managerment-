<%-- 
    Document   : DisplayStore
    Created on : Feb 10, 2022, 4:08:47 PM
    Author     : ptuan
--%>

<%@page import="java.util.Vector"%>
<%@page import="model.DAOstores,entity.stores"%>
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
            Vector<stores> vector = (Vector<stores>)request.getAttribute("list");
            String titleTable = (String) request.getAttribute("titleTabale");

        %>

        <table border="1">
            <caption><%=titleTable%></caption>
            <thead>
                <tr>
                    <th>stor_id</th>
                    <th>stor_name</th>
                    <th>address</th>
                    <th>city</th>
                    <th>state</th>
                    <th>zip</th>
                    <th>SaleDetail</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <%                    for (stores elem : vector) {
                %>
                <tr>
                    <td><%=elem.getStor_id()%></td>
                    <td><%=elem.getStor_name()%></td>
                    <td><%=elem.getStor_address()%></td>
                    <td><%=elem.getCity()%></td>
                    <td><%=elem.getState()%></td>
                    <td><%=elem.getZip()%></td>
                    <td><a href="SalesController?go=viewdetail&storid=<%=elem.getStor_id()%>&storname=<%=elem.getStor_name()%>"> Detail </td>
                    <td><a href="StoresController?go=updateStore&stor_id=<%=elem.getStor_id()%>">Update</td>
                    <td></td>
                    
                    <% } %>
                    
                </tr>
            </tbody>
        </table>
    </body>
</html>
